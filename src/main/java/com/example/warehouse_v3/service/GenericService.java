package com.example.warehouse_v3.service;

import com.example.warehouse_v3.dto.GenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericService<
        D extends GenericDto,
        UD extends BaseDto,
        CD extends BaseDto,
        I extends Serializable> {

    D create(CD createDto) ;

    D update(UD updateDto);

    I delete(I id) ;

    D get(I id) ;

    List<D> getAll();


}
