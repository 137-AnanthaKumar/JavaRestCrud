package Time;

import java.util.Date;
import java.util.TimerTask;

public class Schedulerr extends TimerTask {
	Date now; // to display current time

	// Add your task here
	public void run() {
		now = new Date(); // initialize date
		System.out.println("Time is :" + now); // Display current time
	}
	
	

}
