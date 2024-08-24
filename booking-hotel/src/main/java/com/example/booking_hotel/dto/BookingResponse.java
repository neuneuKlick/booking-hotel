package com.example.booking_hotel.dto;

import com.example.booking_hotel.entity.Room;
import com.example.booking_hotel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private Date checkInDate;
    private Date checkOutDate;
    private Long roomId;
    private Long userId;
}
