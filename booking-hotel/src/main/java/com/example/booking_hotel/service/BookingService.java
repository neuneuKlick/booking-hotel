package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.BookingListResponse;
import com.example.booking_hotel.dto.BookingResponse;
import com.example.booking_hotel.dto.BookingUpsertRequest;
import com.example.booking_hotel.entity.Booking;
import com.example.booking_hotel.entity.Room;
import com.example.booking_hotel.entity.User;
import com.example.booking_hotel.mapper.BookingMapper;
import com.example.booking_hotel.repository.BookingRepository;
import com.example.booking_hotel.repository.RoomRepository;
import com.example.booking_hotel.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public BookingListResponse findAll() {
        return bookingMapper.bookingListToBookingListResponse(bookingRepository.findAll());
    }

    public BookingResponse create(BookingUpsertRequest request) {

        if (!roomRepository.existsById(request.getRoomId())) {
            throw new EntityNotFoundException("Room не найдена");
        }

        if (!userRepository.existsById(request.getUserId())) {
            throw new EntityNotFoundException("Пользователь не найден");
        }

        Booking booking = bookingMapper.bookingUpsertRequestToBooking(request);

        bookingRepository.save(booking);

        return bookingMapper.bookingToBookingResponse(booking);
    }
}
