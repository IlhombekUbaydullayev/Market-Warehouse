package com.example.warehouse_v3.repository;

import com.example.warehouse_v3.model.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User>{
    Optional<User> findByUserNameAndDeletedFalse(String userName);
}
