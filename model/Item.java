package model;

public class Item {
	private String myItemName;
	private String myAuctionName;
	private String myDonor;
	private String myCondition;
	private String mySize;
	private String myNotes;
	private String myDescription;
	private int myUnitQuantity;
	private int mySellingPrice;
	private int myItemNumber;
	private int myMinBid;
	
	public Item(String theItemName){
		myItemName = theItemName;
	}
	
	public String getItemName(){
		return myItemName;
	}
}
