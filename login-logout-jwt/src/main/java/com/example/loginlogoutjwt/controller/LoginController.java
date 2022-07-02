package com.example.loginlogoutjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginlogoutjwt.dto.ApiResponse;
import com.example.loginlogoutjwt.dto.LoginRequestDTO;
import com.example.loginlogoutjwt.dto.SignUpRequestDTO;
import com.example.loginlogoutjwt.entity.User;
import com.example.loginlogoutjwt.jwt.JwtUtils;
import com.example.loginlogoutjwt.service.LoginService;
@RestController
@RequestMapping("/new")
public class LoginController {

	  @Autowired
	  private LoginService loginService;
	  
	  @Autowired
	  private JwtUtils utils;
	
	  @PostMapping("/signup")
	    public ResponseEntity<ApiResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO ){

		  ApiResponse apiResponse = loginService.signUp(signUpRequestDTO);

	        return ResponseEntity
	                .status(apiResponse.getStatus())
	                .body(apiResponse);
	    }
	  
	  @PostMapping("/login")
	    public ResponseEntity<ApiResponse> signUp(@RequestBody LoginRequestDTO loginRequestDTO ){

		  ApiResponse apiResponse = loginService.login(loginRequestDTO);

	        return ResponseEntity
	                .status(apiResponse.getStatus())
	                .body(apiResponse);
	    }
	  
	  @GetMapping("/privateApi")
	  public ResponseEntity<ApiResponse> privateApi(@RequestHeader(value="authorization",defaultValue = "") String auth)throws Exception{
		  ApiResponse apiResponse=new ApiResponse();
		 
		  utils.verify(auth);
		  apiResponse.setData("This Is Private");
		  return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	  }
	  
	  @GetMapping("/getAllUser")
	  public ResponseEntity<ApiResponse> getAlluser(){
		  ApiResponse apires=new ApiResponse();
		  List<User> user=loginService.getAllusers();
		     apires.setData(user);
	return ResponseEntity.status(apires.getStatus()).body(apires);
	  }
}
