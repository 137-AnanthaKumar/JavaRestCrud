package PlayWithArrays;


public class CalculateAvarage {

	public static void main(String[] args) {
		int [] numbers= {12,34,34,34};
		int total=0;
		double avg;
		for(int nu:numbers) {
			
			System.out.println(total+" AND "+nu+"="+(total=total+nu));
		}
		
		avg=total/numbers.length;
		System.out.println("Avarage" +avg);

	}

}
