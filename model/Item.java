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
	
	
	public boolean isValidBid(int theAmount)
	{
		return theAmount >= myMinBid;
	}
	
	/**
	 * @return the myItemName
	 */
	public String getMyItemName() {
		return myItemName;
	}

	/**
	 * @param myItemName the myItemName to set
	 */
	public void setMyItemName(String myItemName) {
		this.myItemName = myItemName;
	}

	/**
	 * @return the myAuctionName
	 */
	public String getMyAuctionName() {
		return myAuctionName;
	}

	/**
	 * @param myAuctionName the myAuctionName to set
	 */
	public void setMyAuctionName(String myAuctionName) {
		this.myAuctionName = myAuctionName;
	}

	/**
	 * @return the myDonor
	 */
	public String getMyDonor() {
		return myDonor;
	}

	/**
	 * @param myDonor the myDonor to set
	 */
	public void setMyDonor(String myDonor) {
		this.myDonor = myDonor;
	}

	/**
	 * @return the myCondition
	 */
	public String getMyCondition() {
		return myCondition;
	}

	/**
	 * @param myCondition the myCondition to set
	 */
	public void setMyCondition(String myCondition) {
		this.myCondition = myCondition;
	}

	/**
	 * @return the mySize
	 */
	public String getMySize() {
		return mySize;
	}

	/**
	 * @param mySize the mySize to set
	 */
	public void setMySize(String mySize) {
		this.mySize = mySize;
	}

	/**
	 * @return the myNotes
	 */
	public String getMyNotes() {
		return myNotes;
	}

	/**
	 * @param myNotes the myNotes to set
	 */
	public void setMyNotes(String myNotes) {
		this.myNotes = myNotes;
	}

	/**
	 * @return the myDescription
	 */
	public String getMyDescription() {
		return myDescription;
	}

	/**
	 * @param myDescription the myDescription to set
	 */
	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}

	/**
	 * @return the myUnitQuantity
	 */
	public int getMyUnitQuantity() {
		return myUnitQuantity;
	}

	/**
	 * @param myUnitQuantity the myUnitQuantity to set
	 */
	public void setMyUnitQuantity(int myUnitQuantity) {
		this.myUnitQuantity = myUnitQuantity;
	}

	/**
	 * @return the mySellingPrice
	 */
	public int getMySellingPrice() {
		return mySellingPrice;
	}

	/**
	 * @param mySellingPrice the mySellingPrice to set
	 */
	public void setMySellingPrice(int mySellingPrice) {
		this.mySellingPrice = mySellingPrice;
	}

	/**
	 * @return the myItemNumber
	 */
	public int getMyItemNumber() {
		return myItemNumber;
	}

	/**
	 * @param myItemNumber the myItemNumber to set
	 */
	public void setMyItemNumber(int myItemNumber) {
		this.myItemNumber = myItemNumber;
	}

	/**
	 * @return the myMinBid
	 */
	public int getMyMinBid() {
		return myMinBid;
	}

	/**
	 * @param myMinBid the myMinBid to set
	 */
	public void setMyMinBid(int myMinBid) {
		this.myMinBid = myMinBid;
	}
	
	public Item(String theItemName){
		myItemName = theItemName;
	}
	
	public String getItemName(){
		return myItemName;
	}
}
