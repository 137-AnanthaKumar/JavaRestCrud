package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePresentBetweenDays {

	public static void main(String[] args) throws ParseException {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date dateBefore = sdf.parse("07/18/2022");
	    Date dateAfter = sdf.parse("07/29/2022");
		System.out.println(dateBefore);
		 Date d = new Date();
		 String currDt = sdf.format(d);
		 if ((d.after(dateBefore) && (d.before(dateAfter)))
			        || (currDt.equals(sdf.format(dateBefore)) || currDt.equals(sdf
			            .format(dateAfter)))) {
			      System.out.println("Date is between ");
			    } else {
			      System.out.println("Date is not between .");
			    }

	}

}
