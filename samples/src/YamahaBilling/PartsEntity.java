package YamahaBilling;

public class PartsEntity {
private String PartNo;
private String NameOfPart;
private int AmountOfPart;
private int Quentity;


private int prize;


public int getPrize() {
	return prize;
}
public void setPrize(int prize) {
	this.prize = prize;
}
public PartsEntity(String partNo, String nameOfPart, int amountOfPart, int quentity, int prize) {
	super();
	PartNo = partNo;
	NameOfPart = nameOfPart;
	AmountOfPart = amountOfPart;
	Quentity = quentity;
	this.prize = prize;
}
public PartsEntity(String partNo, String nameOfPart, int amountOfPart, int quentity) {
	super();
	PartNo = partNo;
	NameOfPart = nameOfPart;
	AmountOfPart = amountOfPart;
	Quentity = quentity;
}
public String getPartNo() {
	return PartNo;
}
public void setPartNo(String partNo) {
	PartNo = partNo;
}
public String getNameOfPart() {
	return NameOfPart;
}
public void setNameOfPart(String nameOfPart) {
	NameOfPart = nameOfPart;
}
public int getAmountOfPart() {
	return AmountOfPart;
}
public void setAmountOfPart(int amountOfPart) {
	AmountOfPart = amountOfPart;
}
public int getQuentity() {
	return Quentity;
}
public void setQuentity(int quentity) {
	Quentity = quentity;
}
public void display() {
	System.out.println("------------------------------------");
	System.out.println("Name Of Part :"+NameOfPart);
	System.out.println("Part Number :"+PartNo);
	System.out.println("Amount of Part :"+AmountOfPart);
	System.out.println("Quentity :"+Quentity);
	System.out.println("------------------------------");

}
}
