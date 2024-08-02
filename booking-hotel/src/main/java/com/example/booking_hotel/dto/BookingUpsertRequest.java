package com.example.booking_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingUpsertRequest {


    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long roomId;
    private Long userId;

}
