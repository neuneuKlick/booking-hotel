package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.*;
import com.example.booking_hotel.entity.Hotel;
import com.example.booking_hotel.exception.NotFoundException;
import com.example.booking_hotel.mapper.HotelMapper;
import com.example.booking_hotel.repository.HotelRepository;
import com.example.booking_hotel.repository.HotelSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public List<HotelResponse> findAll() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::hotelToHotelResponse)
                .collect(Collectors.toList());
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

    public HotelResponse createRating(HotelUpsertRequest request) {
        Hotel hotel = hotelRepository.findById(request.getId()).orElseThrow(() -> new NotFoundException("Отель не найден!"));

        double rating;
        double newMark;
        int numberOfRating;
        double totalRating;

        rating = hotel.getRating();
        numberOfRating = hotel.getReviews();
        totalRating = rating * numberOfRating;

        newMark = request.getRating();
        totalRating = totalRating - rating + newMark;

        rating = totalRating / numberOfRating;

        numberOfRating++;

        hotel.setRating(rating);
        hotel.setReviews(numberOfRating);

        hotelRepository.save(hotel);

        return hotelMapper.hotelToHotelResponse(hotel);
    }

    public HotelListResponse findByFilter(HotelPaginationRequest request) {
        List<Hotel> hotelList = hotelRepository.findAll(HotelSpecification.filter(request),
                PageRequest.of(
                    request.getPageSize(),
                    request.getPageNumber()
                )).getContent();

        return hotelMapper.hotelListToHotelListResponse(hotelList);
    }


}
