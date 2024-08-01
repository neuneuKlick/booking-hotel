package com.example.booking_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpsertRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
}
