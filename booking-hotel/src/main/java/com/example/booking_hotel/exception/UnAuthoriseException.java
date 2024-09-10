package com.example.booking_hotel.exception;

import lombok.Data;

import java.util.Date;

@Data
public class UnAuthoriseException {
    private int status;
    private String message;
    private Date timestamp;

    public UnAuthoriseException(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
