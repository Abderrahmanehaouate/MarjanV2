package com.youcode.marjanv2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        String errorMessage = "{\"error\": \"" + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}

