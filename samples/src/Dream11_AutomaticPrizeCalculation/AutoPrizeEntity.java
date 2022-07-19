package Dream11_AutomaticPrizeCalculation;



public class AutoPrizeEntity {
	
	public int getFromrank() {
		return fromrank;
	}
	public void setFromrank(int fromrank) {
		this.fromrank = fromrank;
	}
	public int getTorank() {
		return torank;
	}
	public void setTorank(int torank) {
		this.torank = torank;
	}
	public int getWinningAmount() {
		return winningAmount;
	}
	public void setWinningAmount(int winningAmount) {
		this.winningAmount = winningAmount;
	}
	private int fromrank;
	private int torank;
	private int winningAmount;
	private int noOfWinners;
	public int getNoOfWinners() {
		return noOfWinners;
	}
	public void setNoOfWinners(int noOfWinners) {
		this.noOfWinners = noOfWinners;
	}

}
