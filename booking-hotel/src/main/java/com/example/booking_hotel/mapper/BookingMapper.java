package com.example.booking_hotel.mapper;

import com.example.booking_hotel.dto.BookingListResponse;
import com.example.booking_hotel.dto.BookingResponse;
import com.example.booking_hotel.dto.BookingUpsertRequest;
import com.example.booking_hotel.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {

    @Mapping(source = "roomId", target = "room.id")
    @Mapping(source = "userId", target = "user.id")
    Booking bookingUpsertRequestToBooking(BookingUpsertRequest request);

    @Mapping(source = "room.id", target = "roomId")
    @Mapping(source = "user.id", target = "userId")
    BookingResponse bookingToBookingResponse(Booking booking);

    default BookingListResponse bookingListToBookingListResponse(List<Booking> bookingList) {
        BookingListResponse bookingListResponse = new BookingListResponse();

        bookingListResponse.setBookingResponseList(bookingList.stream()
                .map(this::bookingToBookingResponse)
                .collect(Collectors.toList()));

        return bookingListResponse;
    }
}
