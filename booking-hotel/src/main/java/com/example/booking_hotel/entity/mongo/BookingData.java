package com.example.booking_hotel.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class BookingData {

    @Id
    private String id;
    private Long userId;
    private String checkInDate;
    private String checkOutDate;

}
