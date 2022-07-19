package PasswordGenerater;

public class ClassB {
	
	String passWord;
	public String createPassWord(String name, String date) {
		
		  String first4charForName = name.substring(0,4).toUpperCase();
		  String last4charForDate = date.substring(0,2);
          passWord=first4charForName+last4charForDate;
          return passWord;
		
	}

}
