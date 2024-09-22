package com.example.booking_hotel.listener;

import com.example.booking_hotel.entity.mongo.BookingData;
import com.example.booking_hotel.entity.mongo.UserData;
import com.example.booking_hotel.repository.mongo.BookingRepositoryStatistics;
import com.example.booking_hotel.repository.mongo.UserRepositoryStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListener {

    private final UserRepositoryStatistics userRepositoryStatistics;
    private final BookingRepositoryStatistics bookingRepositoryStatistics;

    @org.springframework.kafka.annotation.KafkaListener(topics = "${app.kafka.userTopic}",
            groupId = "${app.kafka.kafkaGroupId}",
            containerFactory = "userConcurrentKafkaListenerContainerFactory")
    public void userListener(@Payload UserData messageUser) {
        userRepositoryStatistics.save(messageUser);
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "${app.kafka.bookingTopic}",
            groupId = "${app.kafka.kafkaGroupId}",
            containerFactory = "bookingConcurrentKafkaListenerContainerFactory")
    public void userListener(@Payload BookingData messageBooking) {
        bookingRepositoryStatistics.save(messageBooking);
    }

}
