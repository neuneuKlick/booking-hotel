package com.example.booking_hotel.repository;

import com.example.booking_hotel.entity.BookingUnavailableDate;
import com.example.booking_hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingUnavailableDateRepository extends JpaRepository<BookingUnavailableDate, Long> {

    List<BookingUnavailableDate> findAllByRoom(Room room);

}
