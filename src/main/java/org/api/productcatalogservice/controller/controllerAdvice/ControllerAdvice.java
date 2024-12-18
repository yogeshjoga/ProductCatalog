package org.api.productcatalogservice.controller.controllerAdvice;

import org.api.productcatalogservice.exceptions.IdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> IdNotFoundExcpetion(Exception exception){
        return ResponseEntity.status(404).body(exception.getMessage());
    }
}
