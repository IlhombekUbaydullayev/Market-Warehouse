package com.example.warehouse_v3.controller;

import com.example.warehouse_v3.dto.auth.UserCreate;
import com.example.warehouse_v3.dto.auth.UserLogin;
import com.example.warehouse_v3.dto.auth.UserResponse;
import com.example.warehouse_v3.service.UserService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
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
    public ResponseEntity<UserResponse> create(@RequestBody UserCreate create) throws MessagingException {
        UserResponse userResponse = service.create(create);
        return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
    }

    @GetMapping("/verify")
    public ResponseEntity<UserResponse> verify(@RequestParam String userName,@RequestParam String password) {
        UserResponse verify = service.verify(userName, password);
        return new ResponseEntity<>(verify,HttpStatus.OK);
    }

}
