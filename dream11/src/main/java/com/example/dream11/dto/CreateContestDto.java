package com.example.dream11.dto;

import lombok.Data;

@Data
public class CreateContestDto {
private int contestId;
private String title;
private String contestCode;
private int[] teamsId;
private int contestAmount;
private int totalteams;
private int maxTeamsPerUser;

}
