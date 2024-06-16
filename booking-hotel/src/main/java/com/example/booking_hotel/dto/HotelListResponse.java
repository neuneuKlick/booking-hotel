package com.example.booking_hotel.dto;

import lombok.*;
import org.mapstruct.IterableMapping;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelListResponse {

    List<HotelResponse> hotels = new ArrayList<>();

}
