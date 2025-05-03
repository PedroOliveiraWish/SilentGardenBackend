package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.model.User;
import com.silentgarden.silentgarden.dto.AuthDTO;
import com.silentgarden.silentgarden.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());

        if (user == null || !user.getPassword().equals(loginDTO.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Login successfully");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid User registerUser) {
        User user = userRepository.findByUsername(registerUser.getUsername());

        if (user != null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("username already exists");
        }

        userRepository.save(registerUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User created successfully");
    }
}
