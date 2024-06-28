package com.example.booking_hotel.controller;

import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.dto.HotelUpsertRequest;
import com.example.booking_hotel.dto.UserResponse;
import com.example.booking_hotel.dto.UserUpsertRequest;
import com.example.booking_hotel.entity.RoleType;
import com.example.booking_hotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/search")
    public UserResponse findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserUpsertRequest request,
                               @RequestParam List<RoleType> roleTypes) {
        return userService.create(request, roleTypes);
    }

}
