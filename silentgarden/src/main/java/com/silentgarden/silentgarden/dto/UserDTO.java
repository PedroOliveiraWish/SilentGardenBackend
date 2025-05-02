package com.silentgarden.silentgarden.dto;

import java.util.Date;

public class UserDTO {

    private final String username;
    private final Date created_at;

    public UserDTO(String username, Date created_at) {
        this.username = username;
        this.created_at = created_at;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
