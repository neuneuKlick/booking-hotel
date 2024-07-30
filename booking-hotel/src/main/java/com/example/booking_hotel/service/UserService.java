package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.UserResponse;
import com.example.booking_hotel.dto.UserUpsertRequest;
import com.example.booking_hotel.entity.Role;
import com.example.booking_hotel.entity.RoleType;
import com.example.booking_hotel.entity.User;
import com.example.booking_hotel.exception.BadRequestException;
import com.example.booking_hotel.mapper.UserMapper;
import com.example.booking_hotel.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public UserResponse create(UserUpsertRequest request, RoleType roleType) {

        User user = userMapper.userUpsertRequestToUser(request);

        userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));

        userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        Role role = new Role();
        role.setAuthorities(roleType);
        role.setUser(user);

        userRepository.save(user);

        return userMapper.userToUserResponse(user);

    }
}
