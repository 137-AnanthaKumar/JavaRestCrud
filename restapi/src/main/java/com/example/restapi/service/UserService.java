package com.example.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.dao.UserRepo;
import com.example.restapi.entity.NewUser;

@Service
public class UserService {
    @Autowired
	private UserRepo repo;
    

	public boolean createNewUser(NewUser newuser) {
		
		repo.save(newuser);
        return true;
	}
	
	
	
	public boolean isAvailable(long mobile) {
		System.out.println(mobile);
		NewUser user=new NewUser();
		user=repo.findByMobile(mobile);
		if (user==null) {
			return false;
		}
		return true;
	}

	public List<NewUser> getAllUsers() {
		return repo.findAll();
	}

	public NewUser getuserByMobile(long mobile) {
		// TODO Auto-generated method stub
		NewUser user=new NewUser();
		user=repo.findByMobile(mobile);
		return user;
	}
	
	
	
}
