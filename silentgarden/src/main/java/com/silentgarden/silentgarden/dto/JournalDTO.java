package com.silentgarden.silentgarden.dto;

import java.util.Date;

public class JournalDTO {

    private final String title;

    private final String content;

    private final String username;

    private final Date created_at;

    public JournalDTO(String title, String content, String username, Date created_at) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
