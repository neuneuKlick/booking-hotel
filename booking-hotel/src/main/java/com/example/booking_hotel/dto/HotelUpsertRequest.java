package com.example.booking_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelUpsertRequest {
    private Long id;
    private String name;
    private String title;
    private String city;
    private String address;
    private double location;
    private double rating;
    private int reviews;
}
