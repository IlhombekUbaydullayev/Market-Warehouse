package com.example.warehouse_v3.repository;

import com.example.warehouse_v3.model.Auditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Auditable>  extends JpaRepository<T,Long> {}
