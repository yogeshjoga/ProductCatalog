package org.api.productcatalogservice.controllers.controllerAdvice;


import org.api.productcatalogservice.exceptions.AlreadyUserNamePresent;
import org.api.productcatalogservice.exceptions.PasswordFeildEmpty;
import org.api.productcatalogservice.exceptions.UserNameNullException;
import org.api.productcatalogservice.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundException(Exception ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(UserNameNullException.class)
    public ResponseEntity<String> userNameException(Exception ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(PasswordFeildEmpty.class)
    public ResponseEntity<String> passWord(Exception ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(AlreadyUserNamePresent.class)
    public ResponseEntity<String> userNameWasPresent (Exception ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }
}
