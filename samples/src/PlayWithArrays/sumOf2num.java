package PlayWithArrays;

public class sumOf2num {

	public static void main(String[] args) {
		 int [] nums= {1,3,5,1,2,4};
		 int num=5;
		
		 
		 
		 
		 
		 
		 for(int i=0;i<nums.length; i++) {
			 
			 for(int j=0;j<nums.length;j++) {
				  if((num==nums[i]+nums[j] )&& i<j) {
					  System.out.println("hgg "+nums[i]+" "+nums[j]);
				  }
			 }
		 }
		

	}

}
