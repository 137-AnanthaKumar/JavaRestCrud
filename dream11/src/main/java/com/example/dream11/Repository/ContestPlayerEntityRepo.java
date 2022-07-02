package com.example.dream11.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dream11.Entity.ContestPlayerEntity;
@Repository
public interface ContestPlayerEntityRepo extends JpaRepository<ContestPlayerEntity, Integer> {

}
