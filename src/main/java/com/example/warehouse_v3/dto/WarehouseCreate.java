package com.example.warehouse_v3.dto;

import com.example.warehouse_v3.model.Address;
import com.example.warehouse_v3.service.BaseDto;
import jakarta.servlet.http.HttpServletRequest;

public class WarehouseCreate implements BaseDto {
    public String name;
    public Address address;
    public HttpServletRequest request;
}
