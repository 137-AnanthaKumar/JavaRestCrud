package com.example.dream11.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dream11.Entity.ContestEntity;
import com.example.dream11.Entity.ContestPlayerEntity;
import com.example.dream11.Entity.MyTeam;
import com.example.dream11.Entity.MyTeamPlayersEntity;
import com.example.dream11.Repository.ContestEntityRepo;
import com.example.dream11.Repository.ContestPlayerEntityRepo;
import com.example.dream11.Repository.MyTeamRepo;
import com.example.dream11.commen.ConstantPoints.PLAYER_POINT;
import com.example.dream11.dto.LiveGameDto;

@Service
public class LiveGameService {
//	@Autowired
//    private ContestEntityRepo contestEntityRepo;
	@Autowired
	private TeamsService teamsService;
	@Autowired
	private ContestPlayerEntityRepo contestPlayerRepo;
	
	@Autowired
	private ContestEntityRepo contestEntityRepo;
	
	@Autowired
	private MyTeamRepo myteamRepo;
	
	public String updateDataForRuns(LiveGameDto liveGameDto) {
		//ContestEntity contest=contestEntityRepo.getById(liveGameDto.getContestId());
		
		ContestPlayerEntity player=contestPlayerRepo.getById(liveGameDto.getPlayerId());
		
		
		
	//	HashMap<String, Integer> forWhat = new HashMap<String, Integer>();
		
		if(liveGameDto.getCatches()!=0 ) {
			player.setCatches(player.getCatches()+liveGameDto.getCatches());
			player.setPoints(player.getPoints()+(PLAYER_POINT.CATCH));
			System.out.println("POIYts"+player.getPoints()+(PLAYER_POINT.CATCH));
			contestPlayerRepo.save(player);
			return "CATCH_UPDATED";
		}
		
		else if(liveGameDto.getWicket() !=0) {
			player.setWicket(liveGameDto.getWicket()+player.getWicket());
			player.setPoints(player.getPoints()+PLAYER_POINT.WICKET);
			if(player.getWicket()==5) {
				player.setPoints(player.getPoints()+PLAYER_POINT.FIVEWICKETHALL);
			}
			contestPlayerRepo.save(player);
			return "WICKET_UPDATED";
		}
		
		else if(liveGameDto.getRuns()!=0) {
			
			int i;
			for(i=0;i<liveGameDto.getRuns();i++) {
				player.setRuns(player.getRuns()+1);
				
				player.setPoints(player.getPoints()+(PLAYER_POINT.SINGLERUN));
				
				if(player.getRuns()==50) {
					player.setPoints(player.getPoints()+PLAYER_POINT.FIFTYBONUS);
				}
				if(player.getRuns()==100) {
					player.setPoints(player.getPoints()+PLAYER_POINT.CENTURYBONUS);
				}
				
				
				
			}
			
			if(liveGameDto.getRuns()==4) {
				player.setFours(player.getFours()+1);
				player.setPoints(player.getPoints()+PLAYER_POINT.FOURRUNS);
			}
			if(liveGameDto.getRuns()==6) {
				player.setSix(player.getSix()+1);
				player.setPoints(player.getPoints()+PLAYER_POINT.SIXRUN);
			}
			
			contestPlayerRepo.save(player);
			
			
			//String status=teamsService.setPointsAndRunsPlayerTable(liveGameDto.getContestId());
			//----STORE POINS INDIVIDUL TEAMS
			
			return "RUNS_UPDATED";
			
		}
		
		else {
			return "GIVE_PROPER_INPUT";
		}
		
		
		
		
	}
	//------------------------
	public String reverseUpdateDataForRuns(LiveGameDto liveGameDto) {
		ContestPlayerEntity player=contestPlayerRepo.getById(liveGameDto.getPlayerId());
		if(liveGameDto.getCatches()!=0 ) {
				player.setCatches(player.getCatches()-liveGameDto.getCatches());
				player.setPoints(player.getPoints()-(PLAYER_POINT.CATCH));
				contestPlayerRepo.save(player);
				return "RE_CATCH_UPDATED";
			}
			
			else if(liveGameDto.getWicket() !=0) {
				player.setWicket(liveGameDto.getWicket()-player.getWicket());
				player.setPoints(player.getPoints()-PLAYER_POINT.WICKET);
				if(player.getWicket()==5) {
					player.setPoints(player.getPoints()-PLAYER_POINT.FIVEWICKETHALL);
				}
				contestPlayerRepo.save(player);
				return "RE_WICKET_UPDATED";
			}
			
			else if(liveGameDto.getRuns()!=0) {
				
				int i;
				for(i=0;i<liveGameDto.getRuns();i++) {
					player.setRuns(player.getRuns()-1);
					
					player.setPoints(player.getPoints()-(PLAYER_POINT.SINGLERUN));
					
					if(player.getRuns()==50) {
						player.setPoints(player.getPoints()-PLAYER_POINT.FIFTYBONUS);
					}
					if(player.getRuns()==100) {
						player.setPoints(player.getPoints()-PLAYER_POINT.CENTURYBONUS);
					}
				}
				
				if(liveGameDto.getRuns()==4) {
					player.setFours(player.getFours()-1);
					player.setPoints(player.getPoints()-PLAYER_POINT.FOURRUNS);
				}
				if(liveGameDto.getRuns()==6) {
					player.setSix(player.getSix()-1);
					player.setPoints(player.getPoints()-PLAYER_POINT.SIXRUN);
				}
				
				contestPlayerRepo.save(player);
				return "RE_RUNS_UPDATED";
				
			}
			
			else {
				return "GIVE_PROPER_INPUT";
			}
	}
	
	
//	public MyTeam getMyTeamWithPoints(int teamId) {
//		
//		return myteamRepo.getById(teamId);
//	}
	public String updateAllTeams(String contestCode, int contestId) {
		ContestEntity contestEntity=contestEntityRepo.getById(contestId);
		
		System.out.println("heree");
		ArrayList<MyTeam> team=myteamRepo.findByContestCode(contestCode);
		System.out.println(team.size());
		
		
		for(MyTeam tea:team) {
			
			
			List<MyTeamPlayersEntity> singleTeamplayer=tea.getMyPlayers();
			 ArrayList<Long> totalPoints = new ArrayList<Long>();
			for(MyTeamPlayersEntity myplayer:singleTeamplayer) {
				
				ContestPlayerEntity objj=contestPlayerRepo.getById(myplayer.getPlayerId());
				
				if(myplayer.isCaptain()) {
					myplayer.setPoints(objj.getPoints()*3);
					
				}
				else if(myplayer.isVc()){
					
					myplayer.setPoints(objj.getPoints()*2);
				}
				else {
					myplayer.setPoints(objj.getPoints());

				}
				
				totalPoints.add(myplayer.getPoints());
				
				
				
			}
			
			long sum = 0;

			 for (long number : totalPoints){
			     sum += number;
			 }
			
			
			tea.setMyPlayers(singleTeamplayer);
			tea.setTotalPoits(sum);
			myteamRepo.saveAll(team);
			
			
			
			
			
		}
		return "DONE";
	}
	public Optional<MyTeam> getMyPoints(int teamId) {
		System.out.println("2");
		// TODO Auto-generated method stub
		return myteamRepo.findById(teamId);
	}
	public List<MyTeam> getPointsForContest(String contestCode) {
		
		return myteamRepo.getPoindsFromTop(contestCode);
	}
	public String updatesRanks(String contestCode) {
		List<MyTeam> myteamm=myteamRepo.getPoindsFromTop(contestCode);
		long totalPointsss=1;
		int currentrankkk=0;
		int samepoints=0;
		for(MyTeam object:myteamm) {
			System.out.println(totalPointsss);
			System.out.println(object.getTotalPoits());
			if(totalPointsss==object.getTotalPoits()) {
				object.setMyRank(currentrankkk);
				samepoints=samepoints+1;
				//totalPointsss=object.getTotalPoits();

			}
			else {
				totalPointsss=object.getTotalPoits();
				System.out.println("HRRRRR");
				object.setMyRank(currentrankkk+1);
				currentrankkk=currentrankkk+1;
				
			}
		
		}
		myteamRepo.saveAll(myteamm);
		
		return "SUCESSFULLY_UPDATEDRA";
	}

}
