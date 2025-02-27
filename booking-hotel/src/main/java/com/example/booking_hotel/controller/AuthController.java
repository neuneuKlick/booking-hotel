package com.example.booking_hotel.controller;

import com.example.booking_hotel.dto.JwtRequest;
import com.example.booking_hotel.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest jwtRequest) {
        return authService.createAuthToken(jwtRequest);
    }

}
