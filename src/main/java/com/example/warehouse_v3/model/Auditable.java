package com.example.warehouse_v3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Auditable implements BaseEntity,Serializable {
    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column( name = "created_at", columnDefinition = "TIMESTAMP default NOW()" )
    @DateTimeFormat( pattern = "dd.MM.yyyy HH:mm:ss" )
    private Date createdAt = new Date();
}
