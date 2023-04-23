package com.example.warehouse_v3.exceptions;

import org.springframework.core.NestedRuntimeException;

public class ItemNotFoundException extends NestedRuntimeException {
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
