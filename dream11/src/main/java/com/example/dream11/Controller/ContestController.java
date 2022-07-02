package com.example.dream11.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dream11.Entity.ContestEntity;
import com.example.dream11.Entity.ContestPlayerEntity;
import com.example.dream11.Entity.PlayersEntity;
import com.example.dream11.Entity.TeamsEntity;
import com.example.dream11.Repository.TeamsEntityRepo;
import com.example.dream11.dto.CreateContestDto;
import com.example.dream11.dto.JoinContestDto;
import com.example.dream11.service.ContestService;
import com.example.dream11.service.TeamsService;

@RestController
@RequestMapping("/contest")
public class ContestController {

	@Autowired
	private TeamsService serviceTeam;
	
	@Autowired
	private ContestService contestService;
	@Autowired
	private TeamsEntityRepo teamsEntRepo;
	@PostMapping("/addNewContests")
	public ContestEntity createNewContests(@RequestBody CreateContestDto dto ) {
		String ide1="DREAM";
		
		 int length=5;
		  String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	     
	      
	      String combinedChars = capitalCaseLetters + lowerCaseLetters  ;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	     
	     
	   
	      for(int i = 2; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      
	      String svaa=String.valueOf(password);  
	      System.out.println(svaa);
		
		Date date=new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		 String strDate= formatter.format(date); 
		 
		 
	        

		 // String first4charForName = name.substring(0,4).toUpperCase();
		  String last4charForDate = strDate.substring(0,2);
		 // System.out.println();
         String Ide=ide1+last4charForDate+svaa;

		ContestEntity contestEntity=new ContestEntity();
		contestEntity.setContestCode(Ide);
		contestEntity.setTitle(dto.getTitle());
		contestEntity.setMaxTeamsPerUser(dto.getMaxTeamsPerUser());
		contestEntity.setContestAmount(dto.getContestAmount());
		contestEntity.setTotalTeams(dto.getTotalteams());
		contestEntity.setAvailPlace(dto.getTotalteams());
		
		contestEntity.setEntreFee((dto.getContestAmount())/(dto.getTotalteams()));
		
		
		int[] newArr=new int[dto.getTeamsId().length];
		newArr=dto.getTeamsId();
		
	   for(int id:newArr) {
		
		   TeamsEntity enti=serviceTeam.getPlayers(id);
		  
		   List<PlayersEntity> contestPlayers=enti.getPlayers();
		   for(PlayersEntity entity: contestPlayers) {
			   ContestPlayerEntity contestPlayer=new ContestPlayerEntity();
			   contestPlayer.setPlayerName(entity.getName());
			   contestPlayer.setRole(entity.getRole());
			   contestPlayer.setTeam(enti.getTeamName());
			   contestEntity.addPlayer(contestPlayer);
		   }
		 
	   }
		
		ContestEntity newcontestEntity=contestService.addNewContest(contestEntity);
		return newcontestEntity;
		
		
	}
	
	@GetMapping("/getAllActiveContest")
	public List<ContestEntity> getAllActiveContest() {
		List<ContestEntity> entity=contestService.getAllActiveContest();
		return entity;
		}
	
	@PostMapping("/joinContest")
	public ResponseEntity<String> joinContest(@RequestBody JoinContestDto dto){
		String ststus=contestService.JoiningContest(dto);
		return ResponseEntity.ok(ststus);
		
	}
	
	
	
	


}
