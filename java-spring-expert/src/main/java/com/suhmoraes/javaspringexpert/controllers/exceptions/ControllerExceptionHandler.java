package com.suhmoraes.javaspringexpert.controllers.exceptions;

import com.suhmoraes.javaspringexpert.services.exception.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoun(EntityNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Category Not Found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
