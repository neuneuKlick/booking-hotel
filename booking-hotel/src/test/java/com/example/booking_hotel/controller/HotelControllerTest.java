package com.example.booking_hotel.controller;

import com.example.booking_hotel.AbstractControllerTest;
import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.entity.Hotel;
import com.example.booking_hotel.mapper.HotelMapper;
import com.example.booking_hotel.service.HotelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

public class HotelControllerTest extends AbstractControllerTest {

    @MockBean
    private HotelService hotelService;

    @MockBean
    private HotelMapper hotelMapper;

    @Test
    public void whenFindAll_thenReturnAllHotels() throws Exception {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createHotel(new Hotel(
                1L,
                "Ink",
                "Welcome to Ink Hotel",
                "Dubai",
                "Jaddaf Waterfront Dubai 20, Bur Dubai, Dubai, United Arab Emirates",
                7.6,
                8.0,
                3552
        )));
        hotels.add(createHotel(new Hotel(
                1L,
                "Hotel New Imperial",
                "Welcome to Hotel New Imperial",
                "Mumbai",
                "Apsara cinema, Near Minerva talkies , Ali Bhai Premji Marg, Grant Road(E) Mumbai - 400007, 400007 Mumbai, India",
                8.2,
                9.2,
                40
        )));

        List<HotelResponse> hotelResponses = new ArrayList<>();
        hotelResponses.add(createHotelResponse(new HotelResponse(
                1L,
                "Ink",
                "Welcome to Ink Hotel",
                "Dubai",
                "Jaddaf Waterfront Dubai 20, Bur Dubai, Dubai, United Arab Emirates",
                7.6,
                8.0,
                3552
        )));
        hotelResponses.add(createHotelResponse(new HotelResponse(
                1L,
                "Hotel New Imperial",
                "Welcome to Hotel New Imperial",
                "Mumbai",
                "Apsara cinema, Near Minerva talkies , Ali Bhai Premji Marg, Grant Road(E) Mumbai - 400007, 400007 Mumbai, India",
                8.2,
                9.2,
                40
        )));

        
    }

}
