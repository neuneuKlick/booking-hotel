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
import java.util.List;

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

    private boolean isInputDateUnCorrect(BookingUpsertRequest request) {
        LocalDate inDate = request.getCheckInDate();
        LocalDate outDate = request.getCheckOutDate();
        return outDate.isBefore(inDate);
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


//    private boolean isAvailableDates(BookingUpsertRequest request) {
//
//        LocalDate requestInDate = request.getCheckInDate();
//
//        Room requestRoom = roomRepository.findById(request.getRoomId()).get();
//        List<BookingUnavailableDate> list = bookingUnavailableDateRepository.findAllByRoom(requestRoom);
//
//        for (BookingUnavailableDate bookingUnavailableDate : list) {
//            if (requestInDate.isBefore(bookingUnavailableDate.getCheckOutDate())) {
//                return false;
//            }
//        }
//        return true;
//    }

    public BookingResponse create(BookingUpsertRequest request) {

        if (isBadRequest(request)) {
            throw new BadRequestException("Запрос введён не верно");
        }

        Booking booking = bookingMapper.bookingUpsertRequestToBooking(request);
        List<Booking> list = bookingRepository.findBookingsByDates(
                booking.getCheckInDate(),
                booking.getCheckOutDate());
//                booking.getRoom().getId());

        if (!list.isEmpty()) {
            System.out.println("Свободных дат нет");
        } else {
            System.out.println("Бронирование успешно");
        }

        return bookingMapper.bookingToBookingResponse(booking);
    }
}

//
//
//        if (isAvailableDates(request)) {
//
//            Booking booking = bookingMapper.bookingUpsertRequestToBooking(request);
//
//            BookingUnavailableDate newDate = new BookingUnavailableDate();
//            newDate.setCheckInDate(request.getCheckInDate());
//            newDate.setCheckOutDate(request.getCheckOutDate());
//            newDate.setRoom(roomRepository.findById(request.getRoomId()).get());
//
//            bookingUnavailableDateRepository.save(newDate);
//            bookingRepository.save(booking);
//
//            return bookingMapper.bookingToBookingResponse(booking);
//        } else {
//            throw new BadRequestException("Не можем забронеировать комнату на запрашиваемую дату");
//        }


