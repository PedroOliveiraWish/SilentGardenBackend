package com.silentgarden.silentgarden.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import java.util.*;

@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    @Size(min = 6, max = 255, message = "password must be at least 6 characters")
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @OneToMany(mappedBy = "user")
    private List<Quote> quotes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<SavedQuote> savedQuotes = new ArrayList<>();

    public User() {};

    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }
}

