package com.example.springbootjpa.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import com.example.springbootjpa.response.ResponseHandler;
import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TransientPropertyValueException.class})
    public ResponseEntity<?> handleTransientPropertyValueException(TransientPropertyValueException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<?> handleTSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomNotExistException.class})
    public ResponseEntity<?> handleProductNotExistException(CustomNotExistException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
