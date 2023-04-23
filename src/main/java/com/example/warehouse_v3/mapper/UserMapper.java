package com.example.warehouse_v3.mapper;

import com.example.warehouse_v3.dto.auth.UserCreate;
import com.example.warehouse_v3.dto.auth.UserResponse;
import com.example.warehouse_v3.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends BaseMapper<
        User,
        UserResponse,
        UserCreate,
        UserResponse> {
}

