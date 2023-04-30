package com.example.warehouse_v3.controller;

import com.example.warehouse_v3.dto.AddressResponse;
import com.example.warehouse_v3.dto.AddressUpdate;
import com.example.warehouse_v3.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address-warehouse")
@RequiredArgsConstructor
public class AddressWarehouseController {
    private final AddressService service;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<AddressResponse> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AddressUpdate update) {
        AddressResponse update1 = service.update(update);
        return new ResponseEntity<>(update1,HttpStatus.OK);
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        AddressResponse addressResponse = service.get(id);
        return new ResponseEntity<>(addressResponse,HttpStatus.OK);
    }
}
