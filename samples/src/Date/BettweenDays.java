package Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BettweenDays {

	public static void main(String[] args) {
		
		
		

		try {
			// Convert `String` to `Date`
			   Date now=new Date();
			    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			    Date dateBefore = sdf.parse("04/21/2022");
			    Date dateAfter = sdf.parse("04/25/2022");

			// Calculate the number of days between dates
				long dateNow=now.getTime();
			 //   long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());

			    long timeDiff = Math.abs(dateNow - dateBefore.getTime());
			    long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
			    System.out.println("The number of days between dates: " + daysDiff);
			}catch(Exception e){
			    e.printStackTrace();
			}

	}

}
