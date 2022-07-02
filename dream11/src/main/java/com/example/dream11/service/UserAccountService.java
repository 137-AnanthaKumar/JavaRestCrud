package com.example.dream11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dream11.Entity.UserAccount;
import com.example.dream11.Repository.UserAccountRepo;
import com.example.dream11.Repository.UserEntityRepo;

@Service
public class UserAccountService {
	@Autowired
	private UserAccountRepo repo;
	
	@Autowired
	private UserEntityRepo repoUserEntity;

	public boolean alreadyAvaiable(String accountName, String mail) {
		boolean availStatus=repo.existsByAccountName(accountName);
		boolean availStatusForMail=repoUserEntity.existsByMail(mail);
		if(availStatus || availStatusForMail ){
			return true;
		}
		else if(!availStatus && !availStatusForMail ){
			return false;
		}
		else return true;
	}

	public UserAccount createAccount(UserAccount userAccount) {
		
		return repo.save(userAccount);
	}

	

}
