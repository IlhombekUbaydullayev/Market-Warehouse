package com.example.warehouse_v3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<R extends JpaRepository>{
    protected R repository;
    protected ObjectMapper mapper = new ObjectMapper();
    protected ModelMapper modelMapper = new ModelMapper();
    protected AbstractService(R repository) {
        this.repository = repository;
    }
}
