package com.example.booking_hotel.repository.mongo;

import com.example.booking_hotel.entity.mongo.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoryStatistics extends MongoRepository<UserData, String> {
}
