package com.example.booking_hotel.service.csv;

import com.example.booking_hotel.entity.mongo.BookingData;
import com.example.booking_hotel.entity.mongo.UserData;
import com.example.booking_hotel.repository.mongo.BookingRepositoryStatistics;
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
    private final BookingRepositoryStatistics bookingRepositoryStatistics;

    public void createCsvUsers(String path) {

        try (FileWriter writer = new FileWriter(path)) {
            writer.write("\"Id\", \"UserId\"");
            writer.write("\n");

            List<UserData> users = userRepositoryStatistics.findAll();
            for (UserData user : users) {
                writer.write("\"" + user.getId() + "\",\"" + user.getUserId() + "\"");
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCsvBookings(String path) {

        try (FileWriter writer = new FileWriter(path)) {
            writer.write("\"Id\",\"UserId\",\"BookingIn\",\"BookingOut\"");
            writer.write("\n");

            List<BookingData> bookings = bookingRepositoryStatistics.findAll();
            for (BookingData booking : bookings) {
                writer.write("\"" + booking.getId() + "\",\""
                        + booking.getUserId() + "\""
                        + booking.getCheckInDate() + "\""
                        + booking.getCheckOutDate() + "\"");
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
