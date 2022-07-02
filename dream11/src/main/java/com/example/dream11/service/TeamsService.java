package com.example.dream11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dream11.Entity.ContestPlayerEntity;
import com.example.dream11.Entity.MyTeam;
import com.example.dream11.Entity.MyTeamPlayersEntity;
import com.example.dream11.Entity.TeamsEntity;
import com.example.dream11.Repository.ContestPlayerEntityRepo;
import com.example.dream11.Repository.MyTeamPlayersRepo;
import com.example.dream11.Repository.TeamsEntityRepo;

@Service
public class TeamsService {
	@Autowired
	private TeamsEntityRepo teamRepo;
	@Autowired
	private MyTeamPlayersRepo teamPlayersRepo;
	
	@Autowired
	private ContestPlayerEntityRepo contestPlayerRepo;

	public TeamsEntity addNewTeamToDreamm11(TeamsEntity entity) {
		// TODO Auto-generated method stub
		return teamRepo.save(entity);
	}

	public TeamsEntity getPlayers(int id) {
		TeamsEntity enti=teamRepo.getById(id);
		return enti;
	}

//	public String setPointsAndRunsPlayerTable(int contestId) {
//		List<MyTeam> allTeam=teamRepo.findByContestId(contestId);
//		for(MyTeam team:allTeam) {
//			List<MyTeamPlayersEntity> singleTeamPlayers=team.getMyPlayers();
//			for(MyTeamPlayersEntity singlplayer:singleTeamPlayers) {
//				ContestPlayerEntity obj=contestPlayerRepo.getById(singlplayer.getPlayerId());
//				
//				
//				}
//			
//		}
//		return null;
//	}

}
