package com.example.loginlogoutjwt.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginlogoutjwt.dto.ApiResponse;
import com.example.loginlogoutjwt.dto.LoginRequestDTO;
import com.example.loginlogoutjwt.dto.SignUpRequestDTO;
import com.example.loginlogoutjwt.entity.User;
import com.example.loginlogoutjwt.jwt.JwtUtils;
import com.example.loginlogoutjwt.repo.UserRepo;
@Service  
public class LoginService {
	
	 @Autowired
	 private UserRepo userRepository;
	 
	 @Autowired
	 private JwtUtils utils;

	public ApiResponse signUp(SignUpRequestDTO signUpRequestDTO) {
		
		ApiResponse apiResponse = new ApiResponse();
	    User userEntity = new User();
	    userEntity.setName(signUpRequestDTO.getName());
	    userEntity.setEmail(signUpRequestDTO.getEmail());
	    userEntity.setPhone(signUpRequestDTO.getPhone());
	    userEntity.setPassword(signUpRequestDTO.getPassword());
	    userEntity.setActive(Boolean.TRUE);
	    userEntity.setCreatedAt(LocalDateTime.now());
	    userEntity.setUpdatedAt(LocalDateTime.now());
	    //Store Entity
	    
	    userEntity=userRepository.save(userEntity);
	    apiResponse.setData(userEntity);
	    
		return apiResponse;
		
	}

	public ApiResponse login(LoginRequestDTO loginRequestDTO) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();

        // validation

        // verify user exist with given email and password
        User user = userRepository.findOneIgnoreCaseByEmailAndPassword(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
        // response
        if(user == null){
            apiResponse.setData("User login failed");
            }
       
       // apiResponse.setData(data);
        String token=utils.generateJwt(user);
        
        
        Map<String , Object> data = new HashMap<>();
        data.put("accessToken", token);
        apiResponse.setData(data);
        return apiResponse;
           
        }

	public List<User> getAllusers() {
		return userRepository.findAll();
		
	}
	}


