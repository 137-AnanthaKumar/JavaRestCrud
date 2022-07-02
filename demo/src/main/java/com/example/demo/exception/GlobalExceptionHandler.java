package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(AlreadyHaveBus.class)
	public ResponseEntity<ErrorResponse> alreadyHaveBus(AlreadyHaveBus ob){
		
		ErrorResponse response=new ErrorResponse();
		response.setMessage(ob.getMessage());
		response.setLocalDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		
	}
}
