package com.example.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.entity.NewUser;

@Repository
public interface UserRepo extends JpaRepository<NewUser, Integer> {

	NewUser findByMobile(long mobile);
	
	

}
