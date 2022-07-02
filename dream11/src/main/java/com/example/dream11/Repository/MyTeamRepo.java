package com.example.dream11.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dream11.Entity.MyTeam;
@Repository
public interface MyTeamRepo extends JpaRepository<MyTeam, Integer> {

	 @Query(value="SELECT * FROM my_team  WHERE contest_code=:contestCode ORDER BY total_poits DESC",nativeQuery = true)
	 List<MyTeam> getPoindsFromTop(String contestCode);

	ArrayList<MyTeam> findByContestCode(String contestCode);

	MyTeam getById(int contestId);

}
