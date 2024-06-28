package com.example.booking_hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;

    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(targetClass = RoleType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<RoleType> roles = new HashSet<>();
}
