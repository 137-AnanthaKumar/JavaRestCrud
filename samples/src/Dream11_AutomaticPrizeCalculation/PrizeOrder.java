package Dream11_AutomaticPrizeCalculation;

import java.util.ArrayList;
import java.util.List;

public class PrizeOrder {
	
	
	private int rankFrom;
	private int rankTo;
	private float  winningAmount;
	
	public int getRankFrom() {
		return rankFrom;
	}
	public void setRankFrom(int rankFrom) {
		this.rankFrom = rankFrom;
	}
	public int getRankTo() {
		return rankTo;
	}
	public void setRankTo(int rankTo) {
		this.rankTo = rankTo;
	}
	public float getWinningAmount() {
		return winningAmount;
	}
	public void setWinningAmount(float  winningAmount) {
		this.winningAmount = winningAmount;
	}

	
	public void displayVal(List<PrizeOrder> orders) {
		for(PrizeOrder prizeList:orders) {
			System.out.println("RANK FROM : "+prizeList.rankFrom);
			System.out.println("RANK TO : "+prizeList.rankTo);
			System.out.println("PRIZE AMOUNT "+prizeList.winningAmount);

		}
	}

}
