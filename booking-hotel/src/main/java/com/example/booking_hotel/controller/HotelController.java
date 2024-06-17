package com.example.booking_hotel.controller;

import com.example.booking_hotel.dto.HotelListResponse;
import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.dto.HotelUpsertRequest;
import com.example.booking_hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HotelListResponse findAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HotelResponse findById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public HotelResponse create(@RequestBody HotelUpsertRequest request) {
        return hotelService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HotelResponse update(@RequestBody HotelUpsertRequest request, @PathVariable Long id) {
        return hotelService.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }

}
