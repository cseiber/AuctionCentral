package model;

import java.util.ArrayList;
import java.util.Collection;



public class Auction {
	private NPO NPOname;
	private AuctionDate auctionDate;
//	private String contactPerson;
//	private String contactPhone;
	//private int expectedItems;
	private Collection<Item> myItemList;
	

	public Auction(NPO NPOname,
			int year, int month, int day, int hour, int minute){
		this.NPOname = NPOname;
//		this.contactPerson = contactPerson;
//		this. contactPhone = contactPhone;
		auctionDate = new AuctionDate(year, month, day, hour, minute);
		//expectedItems = expectedItems;
		myItemList = new ArrayList<Item>();
	}
	
	// call isEqual() in item method to implement this method.
	public void addItem(Item theItem){
		myItemList.add(theItem);
	}

	public NPO getNPO(){
		return NPOname;
	}
	
	public AuctionDate getAuctionDate(){
		return auctionDate;
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
