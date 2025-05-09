package com.silentgarden.silentgarden.dto;

import java.util.Date;

public class QuoteDTO {

    private final Integer quote_id;
    private final String quoteText;
    private final String username;
    private final Date created_at;

    public QuoteDTO(Integer quote_id, String quoteText, String username, Date created_at) {
        this.quote_id = quote_id;
        this.quoteText = quoteText;
        this.username = username;
        this.created_at = created_at;
    }

    public Integer getQuoteId() {
        return quote_id;
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
