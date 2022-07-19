package YamahaBilling;

import java.util.ArrayList;

public class Billing {
   
	
	public void getBill(ArrayList<PartsEntity> partsDetails) {
		 ArrayList<Integer> prize = new ArrayList<Integer>();
		
		for(PartsEntity partentity:partsDetails) {
			float quen=partentity.getQuentity();
			int PartPrize=(int) (quen*partentity.getAmountOfPart());
			partentity.setPrize(PartPrize);
			prize.add(PartPrize);
			
       }
		 int sum = 0;

		 for (int number : prize){
		     sum += number;
		 }
		
		 Billing bill=new Billing();
		 bill.getCompleteBill(sum,partsDetails);
		 
		

	}
	
	
	public void getCompleteBill(int sum, ArrayList<PartsEntity> partsDetails) {
		 System.out.println("  PartNum          Amount         Quentity          Prize");
		for(PartsEntity parts:partsDetails) {
			System.out.println("  "+parts.getPartNo()+"              "+parts.getAmountOfPart()+"           "+parts.getQuentity()+  "                     "+parts.getPrize());
		}
		System.out.println("    ");
		System.out.println("Total Cast    :               "  +sum);
	}}
