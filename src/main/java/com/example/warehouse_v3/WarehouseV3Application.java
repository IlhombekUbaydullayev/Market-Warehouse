package com.example.warehouse_v3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class WarehouseV3Application {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseV3Application.class, args);
    }

}
