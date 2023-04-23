package com.example.warehouse_v3.exceptions;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:35
 */
public class UserAlreadyExistException extends RuntimeException {

    private String message;

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException() {
        super();
    }
}
