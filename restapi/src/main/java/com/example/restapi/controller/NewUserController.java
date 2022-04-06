package com.example.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.entity.NewUser;
import com.example.restapi.service.UserService;



@RestController
@RequestMapping("/user")
public class NewUserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/newuserregister")
	public ResponseEntity<String> createNewUser(@RequestBody NewUser newuser){
		  
			
			
			if(!service.isAvailable(newuser.getMobile())) {
				boolean status=service.createNewUser(newuser);
				if (status) {
					return ResponseEntity.ok("User Created!");
				}
				else {
					return ResponseEntity.ok("User Not Created!");

				}
			}
			else {
				return ResponseEntity.ok("User Not Created! Already Have this User");
			}

		
	
		
		
		
	}
	
	@GetMapping
	public List<NewUser> getAllUser(){
	
		return service.getAllUsers();
		
		
	}
	@GetMapping("/getuser/{mobile}")
	public ResponseEntity<NewUser> getUserById(@PathVariable long mobile){
		NewUser user=new NewUser();
		user=service.getuserByMobile(mobile);
		System.out.println(user.getMail());
		if(user!=null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.ok(null);
		
	}
	
	
	
 
}
