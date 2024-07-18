package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }

    public UserNotFoundException(Long userId) {
        this("User not found with id: " + userId);
    }
}