package model;

public class Bid {
	
	//attributes
	
	private String myBidderName;
	
	private int myItemNumber;
	
	private int myBidAmount;
	
	public Bid(String theBidderName, int theItemNumber, int theBidAmount) {
		myBidderName = theBidderName;
		myItemNumber = theItemNumber;
		myBidAmount = theBidAmount;
	}

}
