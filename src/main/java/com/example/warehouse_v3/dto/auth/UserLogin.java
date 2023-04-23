package com.example.warehouse_v3.dto.auth;

import com.example.warehouse_v3.dto.GenericDto;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin extends GenericDto {
    private String userName;
    private String password;
}
