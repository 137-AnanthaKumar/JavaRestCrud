package PasswordGenerater;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ClassA {

	public static void main(String[] args) {
		
		
		//System.out.println("Current Date "+LocalDate.now());
		 Date date=new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		 String strDate= formatter.format(date); 
		 
		 System.out.println(LocalTime.now());
		  String name="Ananth Kumar";
		  
	     	
		  
		  
		
		  ClassB clas=new ClassB();
		  
		  String password=clas.createPassWord(name, strDate);
		  
		  System.out.println(password);
		 
		  PassWordGen1 neww=new PassWordGen1();
		  neww.main(args);
		 
		 
		 
		 
		 
		 
		 

	}

}
