package com.example.booking_hotel;

import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.entity.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected Hotel createHotel(Hotel hotel) {
        return hotel;
    }

    protected HotelResponse createHotelResponse(HotelResponse hotelResponse) {
        return hotelResponse;
    }

}
