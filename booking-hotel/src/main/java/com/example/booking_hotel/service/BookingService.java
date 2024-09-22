package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.BookingListResponse;
import com.example.booking_hotel.dto.BookingResponse;
import com.example.booking_hotel.dto.BookingUpsertRequest;
import com.example.booking_hotel.entity.Booking;
import com.example.booking_hotel.entity.Room;
import com.example.booking_hotel.exception.BadRequestException;
import com.example.booking_hotel.mapper.BookingMapper;
import com.example.booking_hotel.repository.BookingRepository;
import com.example.booking_hotel.repository.RoomRepository;
import com.example.booking_hotel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final KafkaService kafkaService;

    public BookingListResponse findAll() {
        return bookingMapper.bookingListToBookingListResponse(bookingRepository.findAll());
    }

    private boolean isInputDateUnCorrect(BookingUpsertRequest request) {
        Date inDate = request.getCheckInDate();
        Date outDate = request.getCheckOutDate();

        return outDate.before(inDate);
    }

    private boolean isNotFoundRoom(BookingUpsertRequest request) {
        Long roomId = request.getRoomId();
        return roomRepository.findById(roomId).isEmpty();
    }

    private boolean isNotFoundUser(BookingUpsertRequest request) {
        Long userId = request.getUserId();
        return userRepository.findById(userId).isEmpty();
    }

    private boolean isBadRequest(BookingUpsertRequest request) {
        if (isInputDateUnCorrect(request)) {
            throw new BadRequestException("Запрос введён не верно, isInputDateUnCorrect");
        }

        if (isNotFoundRoom(request)) {
            throw new BadRequestException("Запрос введён не верно, isNotFoundRoom");
        }

        if (isNotFoundUser(request)) {
            throw new BadRequestException("Запрос введён не верно, isNotFoundUser");
        }

        return false;
    }


    public BookingResponse create(BookingUpsertRequest request) {

        if (isBadRequest(request)) {
            throw new BadRequestException("Запрос введён не верно");
        }

        List<Booking> list = bookingRepository.findBookingsByDates(request.getCheckInDate(), request.getCheckOutDate(), request.getRoomId());

        if (!list.isEmpty()) {
            throw new BadRequestException("Не можем забронеировать комнату на запрашиваемую дату");
        } else {
            System.out.println("Бронирование успешно");

            Booking booking = bookingMapper.bookingUpsertRequestToBooking(request);
            Booking save = bookingRepository.save(booking);

            kafkaService.sendMessageToKafkaWithTopicName(save);

            return bookingMapper.bookingToBookingResponse(save);
        }
    }
}



