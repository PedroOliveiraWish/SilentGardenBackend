package com.silentgarden.silentgarden.repository;

import com.silentgarden.silentgarden.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername (String username);
}
