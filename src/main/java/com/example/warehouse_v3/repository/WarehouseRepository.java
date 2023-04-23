package com.example.warehouse_v3.repository;

import com.example.warehouse_v3.model.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends BaseRepository<Warehouse>{
    List<Warehouse> findAllByDeletedFalse();
    Optional<Warehouse> findByIdAndDeletedFalse(Long id);
}
