package com.example.booking_hotel.service;

import com.example.booking_hotel.entity.Booking;
import com.example.booking_hotel.entity.User;
import com.example.booking_hotel.entity.mongo.BookingData;
import com.example.booking_hotel.entity.mongo.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {

    @Value("${app.kafka.userTopic}")
    private String userTopicName;

    @Value("${app.kafka.bookingTopic}")
    private String bookingTopicName;

    private final KafkaTemplate<String, UserData> userKafkaTemplate;
    private final KafkaTemplate<String, BookingData> bookingKafkaTemplate;

    public void sendMessageToKafkaWithTopicName(User user) {
        UserData userMessageData = new UserData();
        userMessageData.setId(user.getId());

        userKafkaTemplate.send(userTopicName, userMessageData);
    }

    public void sendMessageToKafkaWithTopicName(Booking booking) {
        BookingData bookingMassageData = new BookingData();
        bookingMassageData.setUserId(booking.getUser().getId());
        bookingMassageData.setCheckInDate(bookingMassageData.getCheckInDate());
        bookingMassageData.setCheckOutDate(bookingMassageData.getCheckOutDate());

        bookingKafkaTemplate.send(bookingTopicName, bookingMassageData);
    }
}
