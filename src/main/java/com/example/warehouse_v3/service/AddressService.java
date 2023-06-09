package com.example.warehouse_v3.service;

import com.example.warehouse_v3.dto.AddressCreate;
import com.example.warehouse_v3.dto.AddressResponse;
import com.example.warehouse_v3.dto.AddressUpdate;
import com.example.warehouse_v3.exceptions.ItemNotFoundException;
import com.example.warehouse_v3.exceptions.handler.ApiMessages;
import com.example.warehouse_v3.mapper.AddressWarehouseMapper;
import com.example.warehouse_v3.model.Address;
import com.example.warehouse_v3.repository.AddressWarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressService extends AbstractService<AddressWarehouseRepository> implements GenericService<
        AddressResponse, AddressUpdate,AddressCreate,Long> {

    private final AddressWarehouseMapper addressWarehouseMapper;

    protected AddressService(AddressWarehouseRepository repository, AddressWarehouseMapper addressWarehouseMapper) {
        super(repository);
        this.addressWarehouseMapper = addressWarehouseMapper;
    }

    @Override
    public AddressResponse create(AddressCreate createDto) {
        log.info(createDto.toString());
//        Address save = repository.save(addressWarehouseMapper.fromCreateDto(createDto));
        return new AddressResponse();
    }

    public Address createAt(Address createDto) {
        log.info(createDto.toString());
        return repository.save(createDto);
    }

    @Override
    public AddressResponse update(AddressUpdate updateDto) {
        Optional<Address> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(updateDto.id);
        if (byIdAndDeletedFalse.isPresent()) {
            Address address = byIdAndDeletedFalse.get();
            if (updateDto.number == 0) updateDto.number = address.getNumber();
            addressWarehouseMapper.fromUpdateDto(updateDto,byIdAndDeletedFalse.get());
            repository.save(address);
            return addressWarehouseMapper.toDto(address);
        } else throw new ItemNotFoundException(ApiMessages.ADDRESS_NOT_FOUND + updateDto.id);
    }

    @Override
    public Long delete(Long id) {
        Optional<Address> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(id);
        if (byIdAndDeletedFalse.isPresent()) {
            Address address = byIdAndDeletedFalse.get();
            address.setDeleted(true);
            repository.save(address);
            return id;
        }else throw new ItemNotFoundException(ApiMessages.ADDRESS_NOT_FOUND + id);
    }

    @Override
    public AddressResponse get(Long id) {
        Optional<Address> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(id);
        if (byIdAndDeletedFalse.isPresent()) {
            Address address = byIdAndDeletedFalse.get();
            return addressWarehouseMapper.toDto(address);
        }else throw new ItemNotFoundException(ApiMessages.ADDRESS_NOT_FOUND + id);
    }

    @Override
    public List<AddressResponse> getAll() {
        return addressWarehouseMapper.toDto(repository.findAllByDeletedFalse());
    }
}
