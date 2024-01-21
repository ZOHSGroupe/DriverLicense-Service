package com.driverlicence.exception;

public class DriverLicenceAlreadyExistsException extends RuntimeException {
    public DriverLicenceAlreadyExistsException(String message) {
        super(message);
    }
}