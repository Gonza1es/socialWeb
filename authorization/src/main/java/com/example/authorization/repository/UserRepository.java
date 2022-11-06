package com.example.authorization.repository;

import com.example.authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
