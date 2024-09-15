package com.example.booking_hotel.controller;

import com.example.booking_hotel.dto.*;
import com.example.booking_hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public List<HotelResponse> findAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public HotelResponse findById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @GetMapping("/filter")
    public HotelListResponse findByFilter(@RequestBody HotelPaginationRequest request) {
        return hotelService.findByFilter(request);
    }

    @PostMapping
    public HotelResponse create(@RequestBody HotelUpsertRequest request) {
        return hotelService.create(request);
    }

    @PutMapping("/{id}")
    public HotelResponse update(@RequestBody HotelUpsertRequest request, @PathVariable Long id) {
        return hotelService.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }

    @PostMapping("/create-rating")
    public HotelResponse createRating(@RequestBody HotelUpsertRequest request) {
        return hotelService.createRating(request);
    }

}
