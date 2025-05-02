package com.silentgarden.silentgarden.dto;

import java.util.Date;

public class SavedQuoteDTO {

    private final String quote;
    private final String username;
    private final Date created_at;
    private final Date saved_at;

    public SavedQuoteDTO(String quote, String username, Date created_at, Date saved_at) {
        this.quote = quote;
        this.username = username;
        this.created_at = created_at;
        this.saved_at = saved_at;
    }

    // getters

    public String getQuote() {
        return quote;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getSaved_at() {
        return saved_at;
    }
}
