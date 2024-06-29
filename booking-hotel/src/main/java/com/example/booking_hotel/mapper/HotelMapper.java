package com.example.booking_hotel.mapper;

import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.dto.HotelUpsertRequest;
import com.example.booking_hotel.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

    Hotel hotelUpsertRequestToHotel(HotelUpsertRequest request);

    @Mapping(source = "id", target = "id")
    Hotel hotelUpsertRequestToHotel(HotelUpsertRequest request, Long id);

    Hotel hotelUpsertRequestToHotel(Long id);

    HotelResponse hotelToHotelResponse(Hotel hotel);

}
