package com.example.booking_hotel.service;

import com.example.booking_hotel.dto.RoomResponse;
import com.example.booking_hotel.dto.RoomUpsertRequest;
import com.example.booking_hotel.entity.Hotel;
import com.example.booking_hotel.entity.Room;
import com.example.booking_hotel.exception.NotFoundException;
import com.example.booking_hotel.mapper.RoomMapper;
import com.example.booking_hotel.repository.HotelRepository;
import com.example.booking_hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;

    public RoomResponse findById(Long id) {
        return roomRepository.findById(id)
                .map(roomMapper::roomToRoomResponse)
                .orElseThrow(() -> new NotFoundException("Комната не найдена!"));
    }

    public RoomResponse create(RoomUpsertRequest request, Long hotelId) {
        Room room = roomMapper.roomUpsertRequestToRoom(request);
        room.setName(request.getName());
        room.setDescription(request.getDescription());
        room.setType(request.getType());
        room.setPrice(request.getPrice());
        room.setNumberOfGuests(request.getNumberOfGuests());
        room.setCheckInDate(request.getCheckInDate());
        room.setCheckOutDate(request.getCheckOutDate());

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new NotFoundException("Отель не найден!"));
        room.setHotel(hotel);

        return roomMapper.roomToRoomResponse(room);
    }

    public RoomResponse update(RoomUpsertRequest request, Long id) {
        Room room = roomMapper.roomUpsertRequestToRoom(request, id);

        return roomRepository.findById(room.getId())
                .map(roomMapper::roomToRoomResponse)
                .orElseThrow(() -> new NotFoundException("Комната не найдена!"));
    }

    public void delete(Long id) {
        roomRepository.deleteById(roomMapper.roomUpsertRequestToRoom(id).getId());
    }

}
