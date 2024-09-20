package com.example.booking_hotel.service;

import com.example.booking_hotel.entity.mongo.User;
import com.example.booking_hotel.repository.mongo.UserRepositoryStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final UserRepositoryStatistics userRepositoryStatistics;

    public void createCsvUsers(String path) {

        try (FileWriter writer = new FileWriter(path)) {
            writer.write("\"Id\", \"UserId\"");
            writer.write("\n");

            List<User> users = userRepositoryStatistics.findAll();
            for (User user : users) {
                writer.write("\"" + user.getId() + "\",\"" + user.getUserId() + "\"");
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
