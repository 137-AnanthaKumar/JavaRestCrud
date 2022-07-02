package com.example.dream11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dream11.Entity.ContestEntity;
import com.example.dream11.Entity.MyTeam;
import com.example.dream11.Entity.MyTeamPlayersEntity;
import com.example.dream11.Entity.UserAccount;
import com.example.dream11.Repository.ContestEntityRepo;
import com.example.dream11.Repository.MyTeamRepo;
import com.example.dream11.Repository.UserAccountRepo;
import com.example.dream11.dto.JoinContestDto;
import com.example.dream11.exception.ContastJoiningFailing;

@Service
public class ContestService {
	
	@Autowired
	private ContestEntityRepo contestRepo;
	
	@Autowired
	private UserAccountRepo userAccountRepo;
	
	@Autowired
	private MyTeamRepo teamRepo;

	public ContestEntity addNewContest(ContestEntity contestEntity) {
		ContestEntity newopj=new ContestEntity();
		return contestRepo.save(contestEntity);
	}

  public List<ContestEntity> getAllActiveContest() {
		
		return contestRepo.getAllActiveContest();
	}







	public String JoiningContest(JoinContestDto dto) {
		ContestEntity newContestObj=contestRepo.getById(dto.getContestId());
		UserAccount userAccountOpj=userAccountRepo.getById(dto.getAccountID());
		long entryBalanse=newContestObj.getEntreFee();
		long currentBalalnse=userAccountOpj.getCurrentAmount();
		
		if(entryBalanse<=currentBalalnse && newContestObj.getAvailPlace()>0  ) {
			MyTeam myteam=new MyTeam();
			myteam.setAccountId(dto.getAccountID());
			myteam.setContestId(dto.getContestId());
			myteam.setContestCode(newContestObj.getContestCode());
			int captain=dto.getCaptainId();
			int vc=dto.getViceCaptainId();
			System.out.println("here");
			int[] newArr=new int[dto.getPlayerIdForThisContest().length];
			newArr=dto.getPlayerIdForThisContest();
			
			List<MyTeamPlayersEntity> myPlyers=myteam.getMyPlayers();
			
     for(int playerId:newArr) {
				
				MyTeamPlayersEntity myPlyer=new MyTeamPlayersEntity();
			System.out.println("helo");
		
				myPlyer.setPlayerId(playerId);
				myPlyer.setPoints(0);
				if(captain==playerId) {
					myPlyer.setCaptain(true);
				}
				if(vc==playerId) {
					myPlyer.setVc(true);
				}
				
				myPlyers.add(myPlyer);
				
			}
			myteam.setMyPlayers(myPlyers);
			teamRepo.save(myteam);
			
			userAccountOpj.setCurrentAmount(userAccountOpj.getCurrentAmount()-entryBalanse);
			userAccountOpj.setTotalamountjoining(userAccountOpj.getTotalamountjoining()+entryBalanse);
			userAccountOpj.setTotalJoinedContest(userAccountOpj.getTotalJoinedContest()+1);
			newContestObj.setAvailPlace(newContestObj.getAvailPlace()-1);
			
			contestRepo.save(newContestObj);
			userAccountRepo.save(userAccountOpj);
			
			
			return "sucess";
		}
		
		
		else {
			throw new ContastJoiningFailing("BalanceLOW","NoError");
		}
		//------
		
		//-------------
		
		
		
	}
	

}
