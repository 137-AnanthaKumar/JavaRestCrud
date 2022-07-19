package samples;

import java.util.Scanner;

public class ReverseNumber {
	 public static void main(String args[])
	   {
	      int num=0;
	      int reversenum =0;
	      System.out.println("Input your number and press enter: ");
	      //This statement will capture the user input
	      Scanner in = new Scanner(System.in);
	      //Captured input would be stored in number num
	      num = in.nextInt();
	      //While Loop: Logic to find out the reverse number
	      int countRender=1;
	      while( num != 0 )
	      {
	    	  System.out.println("RENDER "+countRender);
	    	  countRender++;
	          reversenum = reversenum * 10;
	          reversenum = reversenum + num%10;
	          System.out.println("reversenum "+reversenum);
	          num = num/10;
	          System.out.println("Num Val "+num);
	      }

	      System.out.println("Reverse of input number is: "+reversenum);
	   }
}
