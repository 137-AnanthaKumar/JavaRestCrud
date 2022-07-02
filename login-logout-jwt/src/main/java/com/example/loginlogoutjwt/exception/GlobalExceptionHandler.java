package com.example.loginlogoutjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.loginlogoutjwt.dto.ApiResponse;
@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler
	    public ResponseEntity<ApiResponse> handleException(Exception e){

	        ApiResponse apiResponse = new ApiResponse();
	        apiResponse.setError("Oops..Something went wrong!");
	        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiResponse);
	    }
	  @ExceptionHandler
	    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException e){

	        ApiResponse apiResponse = new ApiResponse();
	        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	        apiResponse.setError(e.getErrors());

	        return ResponseEntity.status(400).body(apiResponse);
	    }
	  
	  @ExceptionHandler(AccessDeniedException.class)
	    public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException e){

	        ApiResponse apiResponse = new ApiResponse();
	      
	        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

	        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	    }

}
