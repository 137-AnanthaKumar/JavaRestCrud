package com.example.demo.exception;

public class AlreadyHaveBus extends RuntimeException{

	public AlreadyHaveBus(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
