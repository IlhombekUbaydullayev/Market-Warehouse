package com.example.warehouse_v3.model;

import com.example.warehouse_v3.enums.Countrys;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AuditEntity {
    private String address_name;
    @Column(name = "number")
    private int number;
    @Enumerated(EnumType.STRING)
    private Countrys country;
}
