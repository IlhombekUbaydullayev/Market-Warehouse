package com.example.warehouse_v3.controller;

import com.example.warehouse_v3.dto.WarehouseCreate;
import com.example.warehouse_v3.dto.WarehouseResponse;
import com.example.warehouse_v3.dto.WarehouseUpdate;
import com.example.warehouse_v3.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService service;
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/getAll")
    public ResponseEntity<List<WarehouseResponse>> getAll() {
        List<WarehouseResponse> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody WarehouseCreate create) {
        WarehouseResponse genericDto = service.create(create);
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
