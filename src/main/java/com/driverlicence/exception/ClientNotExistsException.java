package com.driverlicence.exception;

public class ClientNotExistsException extends RuntimeException {
    public ClientNotExistsException(String message) {
        super(message);
    }
}