package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.UserResponse;
import com.example.booking_hotel.dto.UserUpsertRequest;
import com.example.booking_hotel.entity.RoleType;
import com.example.booking_hotel.entity.User;
import com.example.booking_hotel.mapper.UserMapper;
import com.example.booking_hotel.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EntityNotFoundException("Email уже зарегистрирован");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new EntityNotFoundException("Username уже зарегистрирован");
        }

        User user = userMapper.userUpsertRequestToUser(request);

        user.setRoleType(roleType);

        userRepository.save(user);

        return userMapper.userToUserResponse(user);

    }
}
