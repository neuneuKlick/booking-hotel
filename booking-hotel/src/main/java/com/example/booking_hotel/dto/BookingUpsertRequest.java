package com.example.booking_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingUpsertRequest {


    private Date checkInDate;
    private Date checkOutDate;
    private Long roomId;
    private Long userId;

}
