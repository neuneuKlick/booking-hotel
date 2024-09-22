package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.UserResponse;
import com.example.booking_hotel.dto.UserUpsertRequest;
import com.example.booking_hotel.entity.RoleType;
import com.example.booking_hotel.entity.User;
import com.example.booking_hotel.mapper.UserMapper;
import com.example.booking_hotel.repository.UserRepository;


import com.example.booking_hotel.security.AppUserPrincipal;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KafkaService kafkaService;

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

        kafkaService.sendMessageToKafkaWithTopicName(user);

        return userMapper.userToUserResponse(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));

        return new AppUserPrincipal(user);
    }
}
