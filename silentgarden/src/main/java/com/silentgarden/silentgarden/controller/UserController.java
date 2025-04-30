package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.model.User;
import com.silentgarden.silentgarden.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        User newUser = userRepository.save(user);

        System.out.println("User created: " + newUser.getUsername());

        return newUser;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
