package com.example.sample_mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample_mapping.entity.SavingsAccount;

public interface SavingAccountRepo extends JpaRepository<SavingsAccount, Integer> {

}
