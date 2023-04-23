package com.example.warehouse_v3.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity extends Auditable {

    @LastModifiedDate
    @UpdateTimestamp
    @Column(columnDefinition = "timestamp default now()")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date updatedAt = new Date();

    @CreatedBy
    @Column
    private Long createdBy;

    @Column(columnDefinition = "bool default 'false'")
    private boolean deleted = false;

}
