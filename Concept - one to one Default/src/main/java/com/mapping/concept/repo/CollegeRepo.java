package com.mapping.concept.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.concept.entity.College;


@Repository
public interface CollegeRepo extends JpaRepository<College, Integer> {

}
