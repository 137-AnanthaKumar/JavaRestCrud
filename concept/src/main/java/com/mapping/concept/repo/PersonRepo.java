package com.mapping.concept.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.concept.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
