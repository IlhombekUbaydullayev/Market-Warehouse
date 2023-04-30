package com.example.warehouse_v3.service;

import com.example.warehouse_v3.dto.WarehouseCreate;
import com.example.warehouse_v3.dto.WarehouseResponse;
import com.example.warehouse_v3.dto.WarehouseUpdate;
import com.example.warehouse_v3.exceptions.ItemNotFoundException;
import com.example.warehouse_v3.exceptions.handler.ApiMessages;
import com.example.warehouse_v3.mapper.WarehouseMapper;
import com.example.warehouse_v3.model.Auditable;
import com.example.warehouse_v3.model.User;
import com.example.warehouse_v3.model.Warehouse;
import com.example.warehouse_v3.repository.WarehouseRepository;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WarehouseService extends AbstractService<WarehouseRepository> implements GenericService<
        WarehouseResponse,WarehouseUpdate,WarehouseCreate,Long>{

    private final AddressService service;

    private final UserService userService;
    private final WarehouseMapper warehouseMapper;

    protected WarehouseService(WarehouseRepository repository, AddressService service, UserService userService, WarehouseMapper warehouseMapper) {
        super(repository);
        this.service = service;
        this.userService = userService;
        this.warehouseMapper = warehouseMapper;
    }

    public WarehouseResponse create(WarehouseCreate createDto,HttpServletRequest request) {
        service.createAt(createDto.address);
        Warehouse warehouseResponse = warehouseMapper.fromCreateDto(createDto);
        warehouseResponse.setUserId(response(request.getRemoteUser()));
        Warehouse save = repository.save(warehouseResponse);
        log.info(warehouseResponse.toString());
        return warehouseMapper.toDto(save);
    }

    @Override
    public WarehouseResponse create(WarehouseCreate createDto) throws MessagingException {
        return null;
    }

    @Override
    public WarehouseResponse update(WarehouseUpdate updateDto) {
        Optional<Warehouse> byId = repository.findByIdAndDeletedFalse(updateDto.id);
        if (byId.isPresent()) {
            Warehouse warehouse = byId.get();
            warehouseMapper.fromUpdateDto(updateDto,warehouse);
            Warehouse save = repository.save(warehouse);
            return warehouseMapper.toDto(save);
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
            return warehouseMapper.toDto(byIdAndDeletedFalse.get());
        }else throw new ItemNotFoundException(ApiMessages.USER_NOT_FOUND + id);
    }

    @Override
    public List<WarehouseResponse>getAll() {
        return warehouseMapper.toDto(repository.findAllByDeletedFalse());
    }

    public List<WarehouseResponse> getByUserId() {
        return warehouseMapper.toDto(repository.findAllByUserIdAndDeletedFalse(response(getUser())));
    }

    public Long response(String request) {
        Optional<User> byUserName = userService.getByUserName(request);
        return byUserName.map(Auditable::getId).orElse(null);
    }

    public String getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }else{
            throw new ItemNotFoundException("No User");
        }
    }
}
