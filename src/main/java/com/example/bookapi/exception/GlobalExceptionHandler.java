package com.example.bookapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice //ye global error catch krta haai...controllr k errors handel krta hai..
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String,String> errors=new HashMap<>();
        List<FieldError> fieldErrors=ex.getBindingResult().getFieldErrors();
        for(FieldError error:fieldErrors) {
            String fieldName=error.getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        }
        return  new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

    }

}
