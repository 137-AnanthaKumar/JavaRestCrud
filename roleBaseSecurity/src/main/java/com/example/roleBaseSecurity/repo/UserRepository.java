package com.example.roleBaseSecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.roleBaseSecurity.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
