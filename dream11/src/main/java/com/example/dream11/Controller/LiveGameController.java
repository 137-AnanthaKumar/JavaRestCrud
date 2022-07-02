package com.example.dream11.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dream11.Entity.MyTeam;
import com.example.dream11.dto.LiveGameDto;
import com.example.dream11.service.LiveGameService;

@RestController
@RequestMapping("/liveUpdates")
public class LiveGameController {
	@Autowired
	private LiveGameService liveGameService;
	
	@PutMapping("/updatesRunAndPoints")

	public ResponseEntity<String> updatesPoints(@RequestBody LiveGameDto liveGameDto){
		String responseFromService=liveGameService.updateDataForRuns(liveGameDto);
		
		return ResponseEntity.ok(responseFromService);
		
	}
	
	@PutMapping("/reverseUpdatesRunAndPoints")
	public ResponseEntity<String> reverseUpdatesPoints(@RequestBody LiveGameDto liveGameDto){
		String responseFromService=liveGameService.reverseUpdateDataForRuns(liveGameDto);
		
		return ResponseEntity.ok(responseFromService);
		
	}
	
	@PutMapping("/SetRanks/{contestCode}")
	public ResponseEntity<String> updateRankForPerticularContest(@PathVariable String contestCode){
		
		String responseFromServiceq=liveGameService.updatesRanks(contestCode);
		return ResponseEntity.ok(responseFromServiceq);
		
	}
	
	
	
	
	@PostMapping("/updateAllWithPoints/{contestCode}/{contestId}")
	public ResponseEntity<String> getMyTeamWithPoint(@PathVariable String contestCode, @PathVariable int contestId ){
		 String value=liveGameService.updateAllTeams(contestCode,contestId);
		
		return ResponseEntity.ok(value);
		
	}
	@GetMapping("/getMyteamWithPoints/{teamId}")
	public Optional<MyTeam> getMyTeamWithPoints(@PathVariable int teamId){
		System.out.println("1");
		Optional<MyTeam> myteam=liveGameService.getMyPoints(teamId);
		System.out.println("3");
		return myteam;
		
	}
	
	@GetMapping("getTeamsOrderByPoints/{contestCode}")
	public List<MyTeam> getTeamsOrderByPoints(@PathVariable String contestCode){
		List<MyTeam> myteams=liveGameService.getPointsForContest(contestCode);
		
		return myteams;
		
	}
	
	
	
	

}
