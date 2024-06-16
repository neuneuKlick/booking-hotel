package com.example.booking_hotel.entity;

import jakarta.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String city;
    private String address;
    private double location;
    private double rating;
    private int reviews;
}