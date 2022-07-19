package PlayWithArrays;

public class SpecificValueFromArray {

	public static void main(String[] args) {
		int [] numbers= {12,344,344,43,56};
		int num=23;
	    boolean returenedvalue=isPresent(numbers,num);
	    if(returenedvalue) {
	    	System.out.println("AVAILAVALE");
	    }
	    else {
	    	System.out.println("NOT AVAIL");
	    }

	}
	
	
	
	
	public static Boolean isPresent(int [] array,int num) {
		
		for(int ar: array) {
			if(ar==num) {
				return true;
			}
		}
		
		return false;
		
	}

}
