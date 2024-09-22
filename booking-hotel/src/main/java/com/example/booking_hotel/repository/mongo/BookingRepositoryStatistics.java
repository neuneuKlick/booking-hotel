package com.example.booking_hotel.repository.mongo;

import com.example.booking_hotel.entity.mongo.BookingData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepositoryStatistics extends MongoRepository<BookingData, String> {
}
