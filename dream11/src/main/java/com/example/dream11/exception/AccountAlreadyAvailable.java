package com.example.dream11.exception;

public class AccountAlreadyAvailable extends RuntimeException{
	private static final long serialVersionUID = 1L;

	
	public AccountAlreadyAvailable(String messege) {
		
		super(messege);
	}
}
