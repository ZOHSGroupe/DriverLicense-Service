package com.driverlicence.exception;

public class NotValidDriverLicense extends RuntimeException {
    public NotValidDriverLicense(String message) {
        super(message);
    }
}
