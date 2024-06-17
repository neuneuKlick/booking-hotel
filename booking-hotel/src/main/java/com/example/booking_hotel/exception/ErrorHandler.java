package com.example.booking_hotel.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorMessage handleBadRequestException(BadRequestException exception) {
        log.warn("Client input error, code status 400 {}", exception.getMessage(), exception);
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handleNotFoundException(NotFoundException exception) {
        log.warn("Not found entity in the DB, code status 404 {}", exception.getMessage(), exception);
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(BadGatewayException.class)
    public ErrorMessage handleBadGatewayException(BadGatewayException exception) {
        log.warn("Server error, unchecked exception, code status 500 {}", exception.getMessage(), exception);
        return new ErrorMessage(exception.getMessage());
    }

}
