package com.example.booking_hotel.controller;


import com.example.booking_hotel.dto.BookingListResponse;
import com.example.booking_hotel.dto.BookingResponse;
import com.example.booking_hotel.dto.BookingUpsertRequest;
import com.example.booking_hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public BookingListResponse findAll() {
        return bookingService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse create(@RequestBody BookingUpsertRequest request) {
        return bookingService.create(request);
    }


}
