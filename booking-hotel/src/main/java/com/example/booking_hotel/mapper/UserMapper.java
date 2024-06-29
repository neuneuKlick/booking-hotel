package com.example.booking_hotel.mapper;

import com.example.booking_hotel.dto.UserResponse;
import com.example.booking_hotel.dto.UserUpsertRequest;
import com.example.booking_hotel.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userUpsertRequestToUser(UserUpsertRequest request);

    UserResponse userToUserResponse(User user);

}
