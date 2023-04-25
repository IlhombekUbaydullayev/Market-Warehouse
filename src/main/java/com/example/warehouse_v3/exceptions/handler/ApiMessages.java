package com.example.warehouse_v3.exceptions.handler;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiMessages {
    public static final String USER_NOT_FOUND = "warehouse not found with id : ";
    public static final String ADDRESS_NOT_FOUND = "address_warehouse not found with id : ";
    public static final String USER_NOT_FOUND_ORG = "User not found : ";
}
