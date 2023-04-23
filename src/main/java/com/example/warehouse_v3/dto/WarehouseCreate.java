package com.example.warehouse_v3.dto;

import com.example.warehouse_v3.model.Address;
import com.example.warehouse_v3.service.BaseDto;

public class WarehouseCreate implements BaseDto {
    public String name;
    public Address address;
}
