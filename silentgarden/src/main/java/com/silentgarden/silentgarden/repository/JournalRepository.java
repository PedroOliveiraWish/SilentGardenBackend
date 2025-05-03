package com.silentgarden.silentgarden.repository;

import com.silentgarden.silentgarden.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Integer> {
    List<Journal> findByUserId(Integer id);
}
