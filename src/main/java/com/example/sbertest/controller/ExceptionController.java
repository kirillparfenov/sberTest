package com.example.sbertest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<String> handleInterruptedException(InterruptedException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
