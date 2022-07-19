package Dream11_AutomaticPrizeCalculation;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int contestAmount=2500;
		int totalTeams=20;
		

		float profit=contestAmount*(30f/100f);
	    int inn=Math.round(profit);
	    int contestPrizePool=contestAmount-inn;

	    
	    float winningTeam=totalTeams*(50f/100f);
	    int willWinTeam=Math.round(winningTeam);
	   Main mainOpj=new Main();
	   mainOpj.prizeCalcu(contestPrizePool, willWinTeam);

	}
	
	
	
	public void prizeCalcu(int contestPrizePool,int willWinTeam) {
		
		int contestPrize=contestPrizePool;
	
		boolean status=false;
		float alvailBalance=contestPrizePool;
		
		
		List<PrizeOrder> orders=new ArrayList<PrizeOrder>();
        System.out.println(willWinTeam);
		int currentRank=0;

		
		switch(willWinTeam) {
		case 1: 
			PrizeOrder prizeOrderOpj1=new PrizeOrder();

			prizeOrderOpj1.setRankFrom(0);
			prizeOrderOpj1.setRankTo(1);
			System.out.println("hhh");
			prizeOrderOpj1.setWinningAmount(alvailBalance);
			
			orders.add(prizeOrderOpj1);
			break;
			
		case 2:
			

			for(int i=0;i<willWinTeam;i++) {
				System.out.println("hi"+i);
				  PrizeOrder prizeOrderOpj=new PrizeOrder();

				if((willWinTeam-1)==i) {
					System.out.println("hi");
					prizeOrderOpj.setRankFrom(currentRank);
                    prizeOrderOpj.setRankTo(currentRank);
					prizeOrderOpj.setWinningAmount(alvailBalance);
					
			      }
				if((willWinTeam-1)!=i) {

					System.out.println("hiiii");
					prizeOrderOpj.setRankFrom(currentRank);

					prizeOrderOpj.setRankTo(currentRank+1);
					prizeOrderOpj.setWinningAmount(alvailBalance*(0.60f));
					alvailBalance=alvailBalance-(alvailBalance*(0.60f));
					currentRank=currentRank+1;
	
                  }
				orders.add(prizeOrderOpj);
				}
			  PrizeOrder prizeOrderOpj=new PrizeOrder();
               prizeOrderOpj.displayVal(orders);
			
			
			break;
			 
			default:

				if(willWinTeam>=10) {
					  
					

					
				   if(willWinTeam==10) {
					   PrizeOrder prizeOrderOpj2=new PrizeOrder();

						
						float price=(contestPrize*0.36f)/10;
//						System.out.println(price);
//						int sam=Math.round(price);
						int prize1=(Math.round(price)*10)/5;
						System.out.println(prize1);
					   prizeOrderOpj2.setRankFrom(6);
					   prizeOrderOpj2.setRankTo(10);
					   prizeOrderOpj2.setWinningAmount(prize1);
					   orders.add(prizeOrderOpj2);
					   alvailBalance=alvailBalance-(prize1*5); 
					   
					  
				   }
				   for(int i=0;willWinTeam>6;i++) {
						
				   }
					
					System.out.println(alvailBalance);
					
				}
				break;

		}
			
		
//		if(!status) {
////			PrizeOrder prizeOrderOpj=new PrizeOrder();
//			prizeOrderOpj.setRankFrom(0);
//			prizeOrderOpj.setRankTo(1);
//			prizeOrderOpj.setWinningAmount(alvailBalance%2);
//			alvailBalance=alvailBalance/2;
//			currentRank=1;
//			orders.add(prizeOrderOpj);
//			status=true;
//			System.out.println(alvailBalance);
//
//		}
		
		
		System.out.println(contestPrizePool+" "+willWinTeam +orders.size());
	}
	
	
	

}
