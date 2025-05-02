package com.silentgarden.silentgarden.repository;

import com.silentgarden.silentgarden.model.SavedQuote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface SavedQuoteRepository extends JpaRepository<SavedQuote, Integer>{
    List<SavedQuote> findByUserId(Integer id);
}
