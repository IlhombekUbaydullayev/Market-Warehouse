package com.example.warehouse_v3.controller;

import com.example.warehouse_v3.dto.WarehouseCreate;
import com.example.warehouse_v3.dto.WarehouseResponse;
import com.example.warehouse_v3.dto.WarehouseUpdate;
import com.example.warehouse_v3.service.WarehouseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService service;
//    @PreAuthorize("hasAnyRole('ROLE_USER')")
//    @GetMapping("/getAll")
//    public ResponseEntity<WarehouseResponse> getAll() {
//        WarehouseResponse all = service.getByUserId();
//        return new ResponseEntity<>(all, HttpStatus.OK);
//    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/getAllByUserId")
    public ResponseEntity<List<WarehouseResponse>> getAllByUserId() {
        List<WarehouseResponse> all = service.getByUserId();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody WarehouseCreate create,HttpServletRequest request) {
        WarehouseResponse genericDto = service.create(create,request);
        return new ResponseEntity<>(genericDto,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody WarehouseUpdate update) {
        WarehouseResponse update1 = service.update(update);
        return new ResponseEntity<>(update1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Long delete = service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        WarehouseResponse warehouseResponse = service.get(id);
        return new ResponseEntity<>(warehouseResponse,HttpStatus.OK);
    }
}
