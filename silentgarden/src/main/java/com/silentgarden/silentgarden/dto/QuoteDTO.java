package com.silentgarden.silentgarden.dto;

import java.util.Date;

public class QuoteDTO {

    private final Integer quoteId;
    private final String quoteText;
    private final String username;
    private final Date created_at;

    public QuoteDTO(Integer quoteId, String quoteText, String username, Date created_at) {
        this.quoteId = quoteId;
        this.quoteText = quoteText;
        this.username = username;
        this.created_at = created_at;
    }

    public Integer getQuoteId() {
        return quoteId;
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
