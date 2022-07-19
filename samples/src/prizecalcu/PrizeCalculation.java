package prizecalcu;

public class PrizeCalculation {

	public static void main(String[] args) {
          String b="";
		//String a="1-23";
		String g = "line";
//		char c = g.charAt(0);  // returns 'l'
		
		String a="1-23";
		char[] c_arr = a.toCharArray();
//		System.out.println(c_arr[1]);
		
		boolean initiated=false;
		int breakPoint=0;
		for(int i=0; c_arr.length>i;i++) {
			
			if(!initiated) {
				if(c_arr[i]=='-') {
					System.out.println("Break Point - "+i);	
					breakPoint=i;
					}
					System.out.println(c_arr[i]);
				
			}
			if(initiated) {
				
			}
			

		}
		
		System.out.println(breakPoint);
		
		
//		b+=a.charAt(0);
//		System.out.println(b);
//		
		
	}

}
