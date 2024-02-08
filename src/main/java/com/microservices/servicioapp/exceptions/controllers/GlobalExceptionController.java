package com.microservices.servicioapp.exceptions.controllers;

import com.microservices.servicioapp.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public static ResponseEntity<Map<String, Object>> handResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", resourceNotFoundException.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
