package PlayWithArrays;

public class IndexOfArray {

	public static void main(String[] args) {
		int [] num= {12,13,14,15};
		
		int toIntex=14;
		boolean isAvailInArray=false;
		int i=0;
		for(int nu:num) {
			
			if(nu==toIntex) {
				isAvailInArray=true;
				break;
				
			}
			i =i+1;
			
		}
		if(isAvailInArray) {
			int index=i;
			System.out.println("Index "+i);
		}
		if(!isAvailInArray) {
			System.out.println("Not Available");
		}
		
		
	}

}
