package com.example.dream11.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dream11.Entity.ContestEntity;
@Repository
public interface ContestEntityRepo extends JpaRepository<ContestEntity, Integer> {
	
	
	
	@Query(value = "SELECT * FROM contest_entity u WHERE u.context_status ='Active' ", nativeQuery = true)
	List<ContestEntity> getAllActiveContest();

	
}
