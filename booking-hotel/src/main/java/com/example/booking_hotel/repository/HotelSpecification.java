package com.example.booking_hotel.repository;

import com.example.booking_hotel.dto.HotelPaginationRequest;
import com.example.booking_hotel.entity.Hotel;
import org.springframework.data.jpa.domain.Specification;

public class HotelSpecification {

    public static Specification<Hotel> filter(HotelPaginationRequest request) {
        return Specification.where(byId(request.getId())
                .and(byName(request.getName())));
    }

    private static Specification<Hotel> byId(Long id) {
        return ((root, query, criteriaBuilder) -> {
            if (id == null) {
                return null;
            }

            return criteriaBuilder.equal(root.get(Hotel.Fields.id), id);
        });
    }

    private static Specification<Hotel> byName(String name) {
        return ((root, query, criteriaBuilder) -> {
            if (name == null) {
                return null;
            }

            return criteriaBuilder.equal(root.get(Hotel.Fields.name), name);
        });
    }

}
