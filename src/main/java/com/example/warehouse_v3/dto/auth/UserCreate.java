package com.example.warehouse_v3.dto.auth;

import com.example.warehouse_v3.dto.GenericDto;
import com.example.warehouse_v3.service.BaseDto;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreate implements BaseDto {
    private String userName;
    private String password;
}
