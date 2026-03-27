package edu.eci.arsw.blueprints.controllers;

import edu.eci.arsw.blueprints.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(Exception ex) {
        ApiResponse<Void> response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "invalid request", null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}