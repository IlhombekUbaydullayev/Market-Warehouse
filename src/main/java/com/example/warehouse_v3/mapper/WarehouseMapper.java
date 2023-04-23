package com.example.warehouse_v3.mapper;

import com.example.warehouse_v3.dto.WarehouseCreate;
import com.example.warehouse_v3.dto.WarehouseResponse;
import com.example.warehouse_v3.dto.WarehouseUpdate;
import com.example.warehouse_v3.model.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WarehouseMapper extends BaseMapper<
        Warehouse,
        WarehouseResponse,
        WarehouseCreate,
        WarehouseUpdate> {
}