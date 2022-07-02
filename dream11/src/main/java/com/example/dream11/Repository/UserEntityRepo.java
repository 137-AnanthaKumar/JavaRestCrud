package com.example.dream11.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dream11.Entity.UserEntity;
@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Integer> {

	boolean existsByMail(String mail);

}
