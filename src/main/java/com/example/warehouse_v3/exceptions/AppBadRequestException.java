package com.example.warehouse_v3.exceptions;

public class AppBadRequestException extends RuntimeException {

    public AppBadRequestException(String message) {
        super(message);
    }
}
