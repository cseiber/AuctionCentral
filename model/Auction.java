package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;



public class Auction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6428727641409006380L;
	private NPO NPOname;
	private LocalDateTime auctionDate;
	private int myID;
	//	private String contactPerson;
//	private String contactPhone;
	private int expectedItems;
	private String myNotes;
	private int nextItemID;
	private Collection<Item> myItemList;
	
	public Auction(NPO NPOname, LocalDateTime theDate, int itemCount, String theNotes, int theID){
		this.NPOname = NPOname;
//		this.contactPerson = contactPerson;
//		this. contactPhone = contactPhone;
		myNotes = theNotes;
		auctionDate = theDate;
		expectedItems = itemCount;
		myItemList = new ArrayList<Item>();
		myID = theID;
	}
	
	/**
	 * @return the nPOname
	 */
	public NPO getNPOname() {
		return NPOname;
	}
	/**
	 * @param nPOname the nPOname to set
	 */
	public void setNPOname(NPO nPOname) {
		NPOname = nPOname;
	}
	/**
	 * @return the myID
	 */
	public int getMyID() {
		return myID;
	}
	/**
	 * @param myID the myID to set
	 */
	public void setMyID(int myID) {
		this.myID = myID;
	}
	
	/**
	 * @return the auctionDate
	 */
	public LocalDateTime getAuctionDate() {
		return auctionDate;
	}

	/**
	 * @param auctionDate the auctionDate to set
	 */
	public void setAuctionDate(LocalDateTime auctionDate) {
		this.auctionDate = auctionDate;
	}

	/**
	 * @return the expectedItems
	 */
	public int getExpectedItems() {
		return expectedItems;
	}

	/**
	 * @param expectedItems the expectedItems to set
	 */
	public void setExpectedItems(int expectedItems) {
		this.expectedItems = expectedItems;
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
	 * @return the myItemList
	 */
	public Collection<Item> getMyItemList() {
		return myItemList;
	}

	/**
	 * @param myItemList the myItemList to set
	 */
	public void setMyItemList(Collection<Item> myItemList) {
		this.myItemList = myItemList;
	}
	
//	public Auction(NPO NPOname, LocalDateTime theDate){
//		this.NPOname = NPOname;
////		this.contactPerson = contactPerson;
////		this. contactPhone = contactPhone;
//		auctionDate = theDate;
//		expectedItems = 0;
//		myNotes = "";
//		myItemList = new ArrayList<Item>();
//	}
	
	
	// call isEqual() in item method to implement this method.
	public boolean addItem(String theItemName,String theAuctionName, String theDonor,
			String theCondition, String theSize, String theNote,
			String theDescription, double theMinBid){
		String id = Integer.toString(myID) + Integer.toString(nextItemID);
		int theId = Integer.valueOf(id);
		Item theItem = new Item(theItemName, theAuctionName, theDonor, theCondition, theSize, theNote, theDescription, theMinBid, theId);
		for (Item i : myItemList)
		{
			if (theItem.isEqual(i))
				return false;
		}
		myItemList.add(theItem);
		nextItemID++;
		return true;
	}
	
	public Item getItem(int theItemID)
	{
		Item item = null;
		for (Item i : myItemList)
		{
			if (i.getMyItemID() == theItemID)
				item = i;
		}
		return item;
	}

	public NPO getNPO(){
		return NPOname;
	}
	
//	public int getTotalNumberOfItem(){
//		return myItemList.size();
//	}
	
	public Collection<Item> getItemList(){
		return myItemList;
	}
	
	@Override
	public String toString(){
		int i = 1;
		StringBuilder str = new StringBuilder();
		str.append("NPO Username: " + NPOname.getMyName());
		str.append("\nAuction date: " + getAuctionDate().toString());
		str.append("\nTotal number of items: " + myItemList.size());
		
			for (Item itm : myItemList)
		{
			str.append("\n\tItem " + (i) + ": " + 
					itm.getItemName());
			i++;
		}
		str.append("\n");
		return str.toString();
	}
}
