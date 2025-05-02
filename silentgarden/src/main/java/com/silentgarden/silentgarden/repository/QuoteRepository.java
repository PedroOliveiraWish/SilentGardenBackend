package com.silentgarden.silentgarden.repository;

import com.silentgarden.silentgarden.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findByUserId(Integer id);
}
