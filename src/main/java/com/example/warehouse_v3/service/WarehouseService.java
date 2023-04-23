package com.example.warehouse_v3.service;

import com.example.warehouse_v3.dto.WarehouseCreate;
import com.example.warehouse_v3.dto.WarehouseResponse;
import com.example.warehouse_v3.dto.WarehouseUpdate;
import com.example.warehouse_v3.exceptions.ItemNotFoundException;
import com.example.warehouse_v3.exceptions.handler.ApiMessages;
import com.example.warehouse_v3.mapper.WarehouseMapper;
import com.example.warehouse_v3.model.Warehouse;
import com.example.warehouse_v3.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WarehouseService extends AbstractService<WarehouseRepository> implements GenericService<
        WarehouseResponse,WarehouseUpdate,WarehouseCreate,Long>{

    private final AddressService service;

    private final WarehouseMapper mapper;

    protected WarehouseService(WarehouseRepository repository, AddressService service, WarehouseMapper mapper) {
        super(repository);
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public WarehouseResponse create(WarehouseCreate createDto) {
        service.createAt(createDto.address);
        Warehouse warehouseResponse = mapper.fromCreateDto(createDto);
        Warehouse save = repository.save(warehouseResponse);
        log.info(warehouseResponse.toString());
        return mapper.toDto(save);
    }

    @Override
    public WarehouseResponse update(WarehouseUpdate updateDto) {
        Optional<Warehouse> byId = repository.findByIdAndDeletedFalse(updateDto.id);
        if (byId.isPresent()) {
            Warehouse warehouse = byId.get();
            mapper.fromUpdateDto(updateDto,warehouse);
            Warehouse save = repository.save(warehouse);
            return mapper.toDto(save);
        }else throw new ItemNotFoundException(ApiMessages.USER_NOT_FOUND + updateDto.id);
    }

    @Override
    public Long delete(Long id) {
        Optional<Warehouse> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(id);
        if (byIdAndDeletedFalse.isPresent()) {
            Warehouse warehouse = byIdAndDeletedFalse.get();
            warehouse.setDeleted(true);
            service.delete(warehouse.getAddress().getId());
            repository.save(warehouse);
            return id;
        }else throw new ItemNotFoundException(ApiMessages.USER_NOT_FOUND + id);
    }

    @Override
    public WarehouseResponse get(Long id) {
        Optional<Warehouse> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(id);
        if (byIdAndDeletedFalse.isPresent()) {
            return mapper.toDto(byIdAndDeletedFalse.get());
        }else throw new ItemNotFoundException(ApiMessages.USER_NOT_FOUND + id);
    }

    @Override
    public List<WarehouseResponse>getAll() {
        return mapper.toDto(repository.findAllByDeletedFalse());
    }
}
