package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.dto.HotelUpsertRequest;
import com.example.booking_hotel.dto.UserResponse;
import com.example.booking_hotel.dto.UserUpsertRequest;
import com.example.booking_hotel.entity.Hotel;
import com.example.booking_hotel.entity.RoleType;
import com.example.booking_hotel.entity.User;
import com.example.booking_hotel.exception.NotFoundException;
import com.example.booking_hotel.mapper.UserMapper;
import com.example.booking_hotel.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));

        UserResponse userResponse = userMapper.userToUserResponse(user);
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }

    public UserResponse create(UserUpsertRequest request, List<RoleType> roleTypes) {

        findByUsername(request.getUsername());

        userRepository.findByUsernameAndEmail(request.getUsername(), request.getEmail());

        User user = userMapper.userUpsertRequestToUser(request);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        Set<RoleType> roleTypeSet = new HashSet<>(roleTypes);
        user.setRoles(roleTypeSet);

        userRepository.save(user);

        return userMapper.userToUserResponse(user);
    }
}
