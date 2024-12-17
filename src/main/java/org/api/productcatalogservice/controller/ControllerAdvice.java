package org.api.productcatalogservice.controller;


import org.api.productcatalogservice.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> IdNotFound(Exception exception){
        return ResponseEntity.status(404).body(exception.getMessage());
       // ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);  this is also you can use
    }
}
