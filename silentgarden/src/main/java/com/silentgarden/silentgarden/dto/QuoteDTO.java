package com.silentgarden.silentgarden.dto;

import java.util.Date;

public class QuoteDTO {

    private final String quoteText;
    private final String username;
    private final Date created_at;

    public QuoteDTO(String quoteText, String username, Date created_at) {
        this.quoteText = quoteText;
        this.username = username;
        this.created_at = created_at;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
