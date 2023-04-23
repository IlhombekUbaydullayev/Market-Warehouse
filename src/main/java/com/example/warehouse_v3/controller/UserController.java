package com.example.warehouse_v3.controller;

import com.example.warehouse_v3.dto.auth.UserCreate;
import com.example.warehouse_v3.dto.auth.UserLogin;
import com.example.warehouse_v3.dto.auth.UserResponse;
import com.example.warehouse_v3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController{
    private final UserService service;
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserLogin login) {
        UserResponse response = service.login(login);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@RequestBody UserCreate create) {
        UserResponse userResponse = service.create(create);
        return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
    }
}
