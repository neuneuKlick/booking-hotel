package com.example.booking_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingListResponse {

    private List<BookingResponse> bookingResponseList = new ArrayList<>();

}
