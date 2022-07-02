package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

//	 @Autowired
//	  private EmailSend emailSendservice;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
		
	}
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() {
//		
//		
//		emailSendservice.sendEmail("anandkumartpy@gmail.com", "What the hell??  how dare You .You regected my Order..", "Worning for nelson");
//	}

}
