package com.example.booking_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomUpsertRequest {
    private String name;
    private String description;
    private String type;
    private int price;
    private int numberOfGuests;
}
