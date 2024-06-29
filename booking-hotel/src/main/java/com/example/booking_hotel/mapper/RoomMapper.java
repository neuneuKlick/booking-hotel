package com.example.booking_hotel.mapper;

import com.example.booking_hotel.dto.RoomResponse;
import com.example.booking_hotel.dto.RoomUpsertRequest;
import com.example.booking_hotel.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {

    Room roomUpsertRequestToRoom(RoomUpsertRequest request);

    @Mapping(source = "id", target = "id")
    Room roomUpsertRequestToRoom(RoomUpsertRequest request, Long id);

    Room roomUpsertRequestToRoom(Long id);

    RoomResponse roomToRoomResponse(Room room);

}