package Dream11_AutomaticPrizeCalculation;

import java.util.ArrayList;
import java.util.HashMap;

public class AutoPrizeCal {

	public static void main(String[] args) {
	    HashMap<Integer, Float> rankList = new HashMap<Integer, Float>();
	    ArrayList<AutoPrizeEntity> autoPrize=new ArrayList<AutoPrizeEntity>();
	    rankList.put(1, 15f);
	    AutoPrizeEntity onj=new AutoPrizeEntity();
	    onj.setFromrank(0);
	    onj.setTorank(1);
	    onj.setNoOfWinners(1);
	    onj.setWinningAmount(300);
	    autoPrize.add(onj);
	    
	    AutoPrizeEntity onj1=new AutoPrizeEntity();

	    onj1.setFromrank(2);
	    onj1.setTorank(4);
	    onj1.setNoOfWinners(3);
	    onj1.setWinningAmount(100);
	    autoPrize.add(onj1);
	    
	    AutoPrizeEntity onj2=new AutoPrizeEntity();

	    onj2.setFromrank(5);
	    onj2.setTorank(8);
	    onj2.setNoOfWinners(4);
	    onj2.setWinningAmount(50);
	    autoPrize.add(onj2);
	    
	    AutoPrizeEntity onj3=new AutoPrizeEntity();

	    onj3.setFromrank(9);
	    onj3.setTorank(10);
	    onj3.setNoOfWinners(2);
	    onj3.setWinningAmount(40);
	    autoPrize.add(onj3);
	    

	    for(AutoPrizeEntity onjjj:autoPrize) {
	    	
	    	System.out.println(onjjj.getFromrank()+"---"+onjjj.getTorank()+"===>>>"+onjjj.getWinningAmount()+"====noofwinn "+onjjj.getNoOfWinners());
	    }
ArrayList<Integer> rank=new ArrayList<Integer>(); 
   rank.add(1);
   rank.add(2);
   rank.add(3);
   rank.add(3);
   rank.add(5);
   rank.add(6);
   rank.add(7);
   rank.add(8);
   rank.add(8);
   rank.add(10);
   
   System.out.println(rank);
   
   int min, max;
   min = 5;
   max = 10;
    int length=0;
   for (int i = min ; i <= max; i++) {
	   length=length+1;

   }
   System.out.println(" FINAL length"+length);

   
   HashMap<Integer, Integer> multipleRanks = new HashMap<Integer, Integer>();
   HashMap<Integer, Integer> finalPrizepack = new HashMap<Integer, Integer>();

 
   for(Integer rankobj:rank) {
	   Integer count=multipleRanks.get(rankobj);
	   if(count == null) {
		   multipleRanks.put(rankobj, 1);
	   }
	   else {
		   multipleRanks.put(rankobj,++count);
	   }
}
   System.out.println(multipleRanks);
	   for(int i=0;i<=multipleRanks.size();i++) {
		   if(multipleRanks.get(i)!=null) {
			   
			   
			   int prizeAmount=0;
			   for(AutoPrizeEntity onjjj:autoPrize) {
				   
			    	 if(onjjj.getFromrank()<=i && onjjj.getTorank()>=i) {
			    		 
			    		 if(onjjj.getNoOfWinners()>multipleRanks.get(i)){
			    			 
			    			 
			    			 System.out.println("");
			    		 }
			    		 else if(onjjj.getNoOfWinners()==multipleRanks.get(i)) {
			    			 finalPrizepack.put(i, onjjj.getWinningAmount());
			    		 }
			    	 }
			    }
			   
			   //System.out.println("i "+i+" "+multipleRanks.get(i));

		   }
	   }
	   
	  System.out.println(finalPrizepack); 
	      
   }

	}
	
	
	
	
	
	
	


