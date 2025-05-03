package com.silentgarden.silentgarden.dto;

public class AuthDTO {

    private final String username;
    private final String password;

    public AuthDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
