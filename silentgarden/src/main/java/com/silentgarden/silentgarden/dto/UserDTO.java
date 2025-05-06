package com.silentgarden.silentgarden.dto;

public class UserDTO {

    private final Integer id;
    private final String username;

    public UserDTO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    // getters

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
