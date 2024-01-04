package com.assurance.exception;

public class AssuranceAlreadyExistsException extends RuntimeException {
    public AssuranceAlreadyExistsException(String message) {
        super(message);
    }
}