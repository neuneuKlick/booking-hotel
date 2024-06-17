package com.example.booking_hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Locale;

@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String type;
    private int price;
    private int numberOfGuests;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
