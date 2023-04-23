package com.example.warehouse_v3.service;

import com.example.warehouse_v3.config.auth.JwtService;
import com.example.warehouse_v3.dto.auth.UserCreate;
import com.example.warehouse_v3.dto.auth.UserLogin;
import com.example.warehouse_v3.dto.auth.UserResponse;
import com.example.warehouse_v3.enums.Role;
import com.example.warehouse_v3.mapper.UserMapper;
import com.example.warehouse_v3.model.User;
import com.example.warehouse_v3.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService extends AbstractService<UserRepository> implements GenericService<
        UserResponse, UserCreate,UserCreate,Long> {
    private final UserMapper mapper;
    private final AuthenticationManager manager;
    private final PasswordEncoder encoder;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    protected UserService(UserRepository repository, UserMapper mapper, AuthenticationManager manager, PasswordEncoder encoder, JwtService jwtService, PasswordEncoder passwordEncoder) {
        super(repository);
        this.mapper = mapper;
        this.manager = manager;
        this.encoder = encoder;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse create(UserCreate createDto) {
        var user = User.builder()
                .userName(createDto.getUserName())
                .password(passwordEncoder.encode(createDto.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        User save = repository.save(user);
        var jwtToken = jwtService.generateToken(save);
        return UserResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public UserResponse update(UserCreate updateDto) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }

    @Override
    public UserResponse get(Long id) {
        return null;
    }

    @Override
    public List<UserResponse> getAll() {
        return null;
    }

    public UserResponse login(UserLogin login) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUserName(),login.getPassword()
                )
        );
        var user = repository.findByUserName(login.getUserName()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return UserResponse.builder()
                .token(jwtToken)
                .build();
    }
}
