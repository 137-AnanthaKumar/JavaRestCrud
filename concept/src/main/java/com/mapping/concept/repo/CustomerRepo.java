package com.mapping.concept.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.concept.entity.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
