package com.example.booking_hotel.repository;

import com.example.booking_hotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM bookings b " +
                    "WHERE b.check_in_date BETWEEN :inDate AND :outDate ",
                    nativeQuery = true)
    List<Booking> findBookingsByDates(@Param("inDate") LocalDate inDate,
                                      @Param("outDate") LocalDate outDate);


}
