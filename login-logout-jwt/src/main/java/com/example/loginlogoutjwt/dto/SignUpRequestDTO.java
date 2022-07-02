package com.example.loginlogoutjwt.dto;

import lombok.Data;

@Data
public class SignUpRequestDTO {
	
	private String name;
	private String email;
	private String phone;
	private String password;
	

}
