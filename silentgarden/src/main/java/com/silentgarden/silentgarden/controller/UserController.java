package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.model.User;
import com.silentgarden.silentgarden.repository.UserRepository;
import com.silentgarden.silentgarden.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/get-all-users")
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(
                        user.getUsername(),
                        user.getCreated_at()
                ))
                .collect(Collectors.toList());
    }
}
