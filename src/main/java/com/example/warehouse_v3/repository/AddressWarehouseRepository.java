package com.example.warehouse_v3.repository;

import com.example.warehouse_v3.model.Address;
import com.example.warehouse_v3.model.Warehouse;

import java.util.List;
import java.util.Optional;

public interface AddressWarehouseRepository extends BaseRepository<Address>{
    List<Address> findAllByDeletedFalse();
    Optional<Address> findByIdAndDeletedFalse(Long id);
}
