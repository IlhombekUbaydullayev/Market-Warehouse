package com.example.warehouse_v3.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse extends AuditEntity {
    private String name;
    @OneToOne
    private Address address;
    private Long userId = 0L;
}
