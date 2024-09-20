package com.example.booking_hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private static final String PATH_USERS = "src/main/resources/statistics/users.csv";

    private final CsvService csvService;

    public ResponseEntity<byte[]> getUsersStatistics() {

        csvService.createCsvUsers(PATH_USERS);
        Path path = Paths.get(PATH_USERS);

        try {
            byte[] data = Files.readAllBytes(path);

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + PATH_USERS)
                    .body(data);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
