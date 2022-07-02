package com.example.sample_mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample_mapping.entity.Company;
@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
