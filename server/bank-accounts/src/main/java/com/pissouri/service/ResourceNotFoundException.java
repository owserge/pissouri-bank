package com.pissouri.service;

/**
 * Thrown when a system resource could not be found (or could/should not be retrieved)
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {

        super(message);
    }
}
