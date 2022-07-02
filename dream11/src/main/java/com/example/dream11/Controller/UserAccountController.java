package com.example.dream11.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dream11.Entity.UserAccount;
import com.example.dream11.exception.AccountAlreadyAvailable;
import com.example.dream11.service.UserAccountService;

@RestController
@RequestMapping("/dream11Account")
public class UserAccountController {
	
	@Autowired
	private UserAccountService userActService;
	@PostMapping("/newAccount")
	public ResponseEntity<String> creatDream11Account(@RequestBody UserAccount userAccount) {
		
		
		if(!(userActService.alreadyAvaiable(userAccount.getAccountName(),userAccount.getUser().getMail()))) {
			UserAccount createdAccount=userActService.createAccount(userAccount);
			return ResponseEntity.ok("Created");
			
		}
		else {
			
			throw new AccountAlreadyAvailable("AccountAlreadyTaken");
			
		}
		
		
		
	}

}
