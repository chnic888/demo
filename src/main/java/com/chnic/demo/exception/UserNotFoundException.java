package com.chnic.demo.exception;

/**
 * @author xxx
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
