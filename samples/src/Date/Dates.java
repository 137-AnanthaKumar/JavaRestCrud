package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Dates {

	public static void main(String[] args) {
//		String a="2022/07/03";
//		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//		try {
//			Date date = format.parse(a);
//			System.out.println(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		DateFormat Date = DateFormat.getDateInstance();
		//Initializing Calender Object
		Calendar cals = Calendar.getInstance();
		//Displaying the actual date
		System.out.println("The original Date: " + cals.getTime());
		//Using format() method for conversion
		String currentDate = Date.format(cals.getTime());
		System.out.println("Formatted Date: " + currentDate);
		System.out.println(LocalDate.now());

	}

}
