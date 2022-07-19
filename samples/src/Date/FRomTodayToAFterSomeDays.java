package Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FRomTodayToAFterSomeDays {

	public static void main(String[] args) {
		 Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	        String todate = dateFormat.format(date);

	        Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.DATE, 11);
	        Date todate1 = cal.getTime();    
	        String fromdate = dateFormat.format(todate1);
	        System.out.println(todate+" "+ fromdate);

	}

}
