package com.example.warehouse_v3.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }
}
