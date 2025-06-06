package com.trimblecars.exception;



import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

   
   /* @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

 
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleEnumErrors(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof InvalidFormatException invalidEx) {
            if (invalidEx.getTargetType().isEnum()) {
                String fieldName = invalidEx.getPath().get(0).getFieldName();
                String accepted = Arrays.toString(invalidEx.getTargetType().getEnumConstants());
                String message = String.format("Invalid value for '%s'. Allowed values are: %s", fieldName, accepted);
                return new ResponseEntity<>(Map.of("error", message), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(Map.of("error", "Invalid request."), HttpStatus.BAD_REQUEST);
    }*/
	
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<?> handleIllegalState(IllegalStateException ex) {
	    return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleNotFound(EntityNotFoundException ex) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
	}

}
