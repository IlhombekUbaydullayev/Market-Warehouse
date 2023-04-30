package com.example.warehouse_v3.dto;


import lombok.*;

public class WarehouseResponse extends GenericDto {
    public String name;
    public AddressResponse address;
    public Long userId = 0L;
}
