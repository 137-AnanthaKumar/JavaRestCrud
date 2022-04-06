package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSend {
    @Autowired
	private JavaMailSender mailSend;
	
	public void sendEmail(String toEmail, String body, String subject) {
	SimpleMailMessage mailMsg=new SimpleMailMessage();
	mailMsg.setFrom("ananthakumartpy@gmail.com");
	mailMsg.setTo(toEmail);
	mailMsg.setText(body);
	mailMsg.setSubject(subject);
	mailSend.send(mailMsg);
	System.out.println("MailSent Successfully");
	}
	
}
