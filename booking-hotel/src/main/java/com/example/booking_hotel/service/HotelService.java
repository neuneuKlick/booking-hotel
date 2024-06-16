package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.HotelListResponse;
import com.example.booking_hotel.dto.HotelResponse;
import com.example.booking_hotel.dto.HotelUpsertRequest;
import com.example.booking_hotel.entity.Hotel;
import com.example.booking_hotel.exception.NotFoundException;
import com.example.booking_hotel.mapper.HotelMapper;
import com.example.booking_hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelListResponse findAll() {
        HotelListResponse response = new HotelListResponse();
        response.setHotels(hotelRepository.findAll().stream()
                .map(hotelMapper::hotelToHotelResponse)
                .collect(Collectors.toList()));

        return response;
    }

    public HotelResponse findById(Long id) {
        return hotelRepository.findById(id)
                .map(hotelMapper::hotelToHotelResponse)
                .orElseThrow(() -> new NotFoundException("Отель не найден!"));
    }

    public HotelResponse create(HotelUpsertRequest request) {
        Hotel hotel = hotelMapper.hotelUpsertRequestToHotel(request);
        hotel.setName(request.getName());
        hotel.setTitle(request.getTitle());
        hotel.setCity(request.getCity());
        hotel.setAddress(request.getAddress());
        hotel.setLocation(request.getLocation());
        hotel.setRating(request.getRating());
        hotel.setReviews(request.getReviews());

        hotelRepository.save(hotel);

        return hotelMapper.hotelToHotelResponse(hotel);
    }

    public HotelResponse update(HotelUpsertRequest request, Long id) {
        Hotel hotel = hotelMapper.hotelUpsertRequestToHotel(request, id);

        return hotelRepository.findById(hotel.getId())
                .map(hotelMapper::hotelToHotelResponse)
                .orElseThrow(() -> new NotFoundException("Отель не найден!"));
    }

    public void delete(Long id) {
        hotelRepository.deleteById(hotelMapper.hotelUpsertRequestToHotel(id).getId());
    }


}
