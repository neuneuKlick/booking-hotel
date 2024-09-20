package com.example.booking_hotel.controller;

import com.example.booking_hotel.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/user")
    public ResponseEntity<byte[]> getUsers() {
        return statisticsService.getUsersStatistics();
    }

}
