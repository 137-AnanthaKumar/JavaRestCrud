package com.example.sample_mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample_mapping.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
