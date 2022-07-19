package YamahaBilling;



import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		ArrayList<PartsEntity>partsDetails=new ArrayList<PartsEntity>();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("To Add New PART ENter 1");
		int userOpt =sc.nextInt();
		while(userOpt==1) {
			Scanner scPart=new Scanner(System.in);
		    System.out.println("Enter The PartNumber");
		    String partNo= scPart.nextLine();
		    System.out.println("Enter Amount");
		    Integer Amount=scPart.nextInt();
		    System.out.println("Enter Quentity :");
		    Integer quentity=scPart.nextInt();
		    System.out.println("Enter The PartName");
		    String partName=scPart.nextLine();
			partsDetails.add(new PartsEntity(partNo,partName,  Amount ,quentity));
		     partName="";
		     partNo="";
		     Amount=null;
		     quentity=null;
		     
		     for(PartsEntity p:partsDetails) {
		    	 p.display();
		     }
		    System.out.println("Enter 1 to Add More Or Enter 2 to Exit ENter 3 to Get Bill");
		    int userOp= sc.nextInt();
		     if(userOp==1) {
		    	 userOpt=1;
		     }
		     else if(userOp==3) {
		    	 Billing bill=new Billing();
		    	 bill.getBill(partsDetails);
		    	 userOpt=2;
		     }
		     else {
		    	 System.out.println("Exited");
		    	 userOpt=2;
		     }
		}
		
		
	     
	   
	}

}
