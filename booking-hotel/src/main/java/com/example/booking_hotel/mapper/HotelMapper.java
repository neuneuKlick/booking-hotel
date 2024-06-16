package com.example.booking_hotel.mapper;

import com.example.booking_hotel.dto.HotelListResponse;
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

    @Mapping(source = "id", target = "id")
    Hotel hotelUpsertRequestToHotel(HotelUpsertRequest request, Long id);

    Hotel hotelUpsertRequestToHotel(Long id);

    HotelResponse hotelToHotelResponse(Hotel hotel);

//    HotelListResponse hotelResponseToHotelListResponse(HotelResponse response);


//    default HotelListResponse hotelResponseListToHotelListResponse(List<HotelResponse> hotelResponseList) {
//        HotelListResponse response = new HotelListResponse();
//        response.setHotels(hotelResponseList.stream()
//                .map(this::hotelToHotelResponse)
//                .collect(Collectors.toList()));
//        return response;
//    }
}
