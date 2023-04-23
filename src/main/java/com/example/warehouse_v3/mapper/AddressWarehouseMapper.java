package com.example.warehouse_v3.mapper;

import com.example.warehouse_v3.dto.*;
import com.example.warehouse_v3.model.Address;
import com.example.warehouse_v3.model.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressWarehouseMapper extends BaseMapper<
        Address,
        AddressResponse,
        AddressCreate,
        AddressUpdate> {
}