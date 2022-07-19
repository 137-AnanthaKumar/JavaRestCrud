package Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        String a=sdf.format(cal.getTime());
	        System.out.println( sdf.format(cal.getTime()) );
	        System.out.println(a);
	}

}
