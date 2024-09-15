package com.example.booking_hotel.mapper;

import com.example.booking_hotel.dto.HotelListResponse;
import com.example.booking_hotel.dto.HotelPaginationResponse;
import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.dto.HotelUpsertRequest;
import com.example.booking_hotel.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

    Hotel hotelUpsertRequestToHotel(HotelUpsertRequest request);

    Hotel hotelUpsertRequestToHotel(HotelUpsertRequest request, Long hotelId);

    Hotel hotelUpsertRequestToHotel(Long id);

    HotelResponse hotelToHotelResponse(Hotel hotel);

    HotelResponse hotelToResponseByRating(Hotel hotel);

    default HotelListResponse hotelListToHotelListResponse(List<Hotel> list) {
        HotelListResponse response = new HotelListResponse();

        response.setHotelResponseList(list.stream()
                .map(this::hotelToResponseByRating)
                .collect(Collectors.toList()));

        return response;
    }

}
