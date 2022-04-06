package com.example.restapi.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dao.UserRepo;
import com.example.restapi.dtp.OtpDto;
import com.example.restapi.entity.NewUser;
import com.example.restapi.twiliosms.SmsSender;

@RestController
@RequestMapping("/otpverifications")
public class UserVerificationController {
	@Autowired
	private SmsSender smssend;

	@Autowired
	private UserRepo repo;
	OtpDto otprr=new OtpDto();
	
	@PostMapping("/getotp/{phone}")
	 public ResponseEntity<String> sentOtp(@PathVariable String phone) {
		 
		 
			    
				String phoneNo= phone;
				int h = new Random().nextInt(900000) + 100000;
				String messege="Your One Time PassWord is"+" "+h;
				otprr.setDefaultOtp(h);
//				smssend.sendSms(phoneNo, messege);
				
				return ResponseEntity.ok("Successfully Send Otp..!"+h);
				
				
		 }
	
	@PutMapping("/verifyotp/{phoneNo}")
	 public  ResponseEntity<String>  VerifyOtpByPhoneNo(@PathVariable String phoneNo,@RequestBody OtpDto otp ){
		
			 

			 if( otprr.getDefaultOtp() !=0 && otp.getOtp()==otprr.getDefaultOtp()) {
//				 System.out.println(otprr.getDefaultOtp());
				 NewUser userOpj=new NewUser();
				 long mobNo=Long.parseLong(phoneNo);
				 userOpj=repo.findByMobile(mobNo);
				 userOpj.setMobileVerifyStatus("Verified");
				
				 repo.save(userOpj);
//					smssend.sendSms(phoneNo, "otpVerifiCation success...");

				 System.out.println("Completed");
				 
				 
				 return ResponseEntity.ok("Otp Verified SusssesFully..!");
				 }
			 else if(otprr.getNoOfAttemt()==0 && otp.getOtp()!=otprr.getDefaultOtp() ) {
				 otprr.setNoOfAttemt(1);
				 System.out.println(otp.getOtp());
//				 System.out.println(c);

//					smssend.sendSms(phoneNo, "You entered Wrong otp You have 2 left");

				 return ResponseEntity.ok("Wrong Otp .Enter Again.2 left!");

	           
			 }
			 else if(otprr.getNoOfAttemt()==1 && otp.getOtp()!=otprr.getDefaultOtp() ) {
				 otprr.setNoOfAttemt(2);
				 System.out.println(otp.getOtp());
//				 System.out.println(i);

//					smssend.sendSms(phoneNo, "You entered Wrong otp You have 1left");

				 return ResponseEntity.ok("Wrong Otp .Enter Again.1 left!");

	           
			 }
			 else if( otprr.getNoOfAttemt()==2&& otp.getOtp()!=otprr.getDefaultOtp() ) {
				
				 System.out.println(otp.getOtp());
				 
//				 System.out.println(i);
				 otprr.setDefaultOtp(0);
//					smssend.sendSms(phoneNo, "You Entered Wrong Otp Again and again Plese Try Again..");

				 return ResponseEntity.ok("You Entered Wrong Otp Again and again Plese Try Again..!");
	           
			 }

			
			 else {
				 return ResponseEntity.ok("SomeThing Wrong Try Again.!");

			 }
			
		
	 }
	
//	@PutMapping("/verifyotpbymail/{name}/{phone}")
//	 public  ResponseEntity<String>  VerifyOtpByMail(@PathVariable String phone,@PathVariable String name,@RequestBody OtpDto otp ){
//		
//			 
//
//			 if( otprr.getDefaultOtp() !=0 && otp.getOtp()==otprr.getDefaultOtp()) {
////				 System.out.println(otprr.getDefaultOtp());
//				 NewUser userOpj=new NewUser();
//				 long mobNo=Long.parseLong(phoneNo);
//				 userOpj=repo.findByMobile(mobNo);
//				 userOpj.setMobileVerifyStatus("Verified");
//				
//				 repo.save(userOpj);
////					smssend.sendSms(phoneNo, "otpVerifiCation success...");
//
//				 System.out.println("Completed");
//				 
//				 
//				 return ResponseEntity.ok("Otp Verified SusssesFully..!");
//				 }
//			 else if(otprr.getNoOfAttemt()==0 && otp.getOtp()!=otprr.getDefaultOtp() ) {
//				 otprr.setNoOfAttemt(1);
//				 System.out.println(otp.getOtp());
////				 System.out.println(c);
//
////					smssend.sendSms(phoneNo, "You entered Wrong otp You have 2 left");
//
//				 return ResponseEntity.ok("Wrong Otp .Enter Again.2 left!");
//
//	           
//			 }
//			 else if(otprr.getNoOfAttemt()==1 && otp.getOtp()!=otprr.getDefaultOtp() ) {
//				 otprr.setNoOfAttemt(2);
//				 System.out.println(otp.getOtp());
////				 System.out.println(i);
//
////					smssend.sendSms(phoneNo, "You entered Wrong otp You have 1left");
//
//				 return ResponseEntity.ok("Wrong Otp .Enter Again.1 left!");
//
//	           
//			 }
//			 else if( otprr.getNoOfAttemt()==2&& otp.getOtp()!=otprr.getDefaultOtp() ) {
//				
//				 System.out.println(otp.getOtp());
//				 
////				 System.out.println(i);
//				 otprr.setDefaultOtp(0);
////					smssend.sendSms(phoneNo, "You Entered Wrong Otp Again and again Plese Try Again..");
//
//				 return ResponseEntity.ok("You Entered Wrong Otp Again and again Plese Try Again..!");
//	           
//			 }
//
//			
//			 else {
//				 return ResponseEntity.ok("SomeThing Wrong Try Again.!");
//
//			 }
//	}

	
	
}
