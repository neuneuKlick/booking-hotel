package com.example.booking_hotel.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String role;
}
