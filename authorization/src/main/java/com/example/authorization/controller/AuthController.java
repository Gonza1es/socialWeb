package com.example.authorization.controller;

import com.example.authorization.dto.LoginRequest;
import com.example.authorization.model.User;
import com.example.authorization.repository.UserRepository;
import com.example.authorization.security.jwt.JwtTokenProvider;
import com.example.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {


    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    private UserRepository userRepository;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider,
                          UserService userService,
                          UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            String username = loginRequest.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("Пользователь не найден");
            }
            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Неверный логин или пароль");
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return ResponseEntity.badRequest().body("Пользователь с таким логином уже существует");

        if (userRepository.existsByEmail(user.getEmail()))
            return ResponseEntity.badRequest().body("Пользователь с таким email уже существует");

        userService.register(user);
        return ResponseEntity.ok("Регистрация прошла успешно");

    }

}
