package com.example.dream11.dto;

import lombok.Data;

@Data
public class JoinContestDto {
	
	
	private int contestId;
	
	private int accountID;
	private int captainId;
	private int viceCaptainId;
	private int[] playerIdForThisContest= {};

}
