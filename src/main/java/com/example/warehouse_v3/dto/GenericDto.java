package com.example.warehouse_v3.dto;

import com.example.warehouse_v3.service.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GenericDto implements BaseDto {
    public Long id;

}