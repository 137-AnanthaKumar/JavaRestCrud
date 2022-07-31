package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2 {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		System.out.println("JAVA DATE FORMAT ::"+date);
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate= DateFor.format(date);
		System.out.println("String Date ::"+stringDate);
		
		
//		    String sDate1=stringDate;  
		    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);  
		    System.out.println("STRING TO NORMAL FORMAT"+"\t"+date1);  
	}

}
