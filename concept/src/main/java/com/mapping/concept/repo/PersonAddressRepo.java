package com.mapping.concept.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.concept.entity.PersonAddress;

@Repository
public interface PersonAddressRepo extends JpaRepository<PersonAddress, Integer> {

}
