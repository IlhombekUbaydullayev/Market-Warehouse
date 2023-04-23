package com.example.warehouse_v3.mapper;

import com.example.warehouse_v3.dto.GenericDto;
import com.example.warehouse_v3.model.BaseEntity;
import com.example.warehouse_v3.service.BaseDto;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto> extends GenericMapper {

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    void fromUpdateDto(UD ud, @MappingTarget E entity);

}
