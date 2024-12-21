package org.api.productcatalogservice.exceptions;

public class AlreadyUserNamePresent extends RuntimeException {
    public AlreadyUserNamePresent(String message) {
        super(message);
    }
}
