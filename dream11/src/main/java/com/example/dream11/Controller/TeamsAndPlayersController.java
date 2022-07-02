package com.example.dream11.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dream11.Entity.TeamsEntity;
import com.example.dream11.service.TeamsService;

@RestController
@RequestMapping("/teams")
public class TeamsAndPlayersController {
	@Autowired
	private TeamsService teamsService;
	
	@PostMapping("/addNewTeam")
	public ResponseEntity<String> addTeamAndPlayers(@RequestBody TeamsEntity entity){
		
		TeamsEntity newEntity=teamsService.addNewTeamToDreamm11(entity);
		return ResponseEntity.ok("SUCCESS");
		
	}

}
