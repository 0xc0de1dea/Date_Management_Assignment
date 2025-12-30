package com.example.routine.exception;

import com.example.routine.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getErrorCode(), e.getErrorMessage()), HttpStatus.BAD_REQUEST);
    }
}
