package com.example.sample_mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample_mapping.entity.SavingsTransaction;

public interface SavingTransactionRepo extends JpaRepository<SavingsTransaction, Integer> {

}
