package com.example.booking_hotel.controller;

import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.dto.HotelUpsertRequest;
import com.example.booking_hotel.dto.RoomResponse;
import com.example.booking_hotel.dto.RoomUpsertRequest;
import com.example.booking_hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private RoomService roomService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse findById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse create(@RequestBody RoomUpsertRequest request, @PathVariable Long hotelId) {
        return roomService.create(request, hotelId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomResponse update(@RequestBody RoomUpsertRequest request, @PathVariable Long id) {
        return roomService.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }

}
