package com.example.warehouse_v3.dto;

import com.example.warehouse_v3.enums.Countrys;
import com.example.warehouse_v3.service.BaseDto;

public class AddressCreate implements BaseDto {
    public String address_name;
    public int number;
    public Countrys country;
}
