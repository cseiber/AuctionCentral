package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class Auction {
	private NPO NPOname;
	private Date myDate;
	private String ContactPerson;
	private String ContactPhone;
	private int expectedItems;
	private String auctionTime;
	private Collection<Item> myItemList;
	
	public Auction(NPO NPOname, int expectItems){
		this.NPOname = NPOname;
		//myDate = new Date();
		//ContactPerson = theContactPerson;
		//ContactPhone = theContactPhone;
		//this.auctionTime = auctionTime;
		expectedItems = expectedItems;
		myItemList = new ArrayList<Item>();
	}
	
	public void addItem(Item theItem){
		myItemList.add(theItem);
	}

	public NPO getNPO(){
		return NPOname;
	}
	
	public Collection<Item> getItemList(){
		return myItemList;
	}
	
	@Override
	public String toString(){
		int i = 1;
		StringBuilder str = new StringBuilder();
		str.append("NPO Username: " + NPOname.getMyName());
		str.append("\nTotal number of items: " + myItemList.size());
		
			for (Item itm : myItemList)
		{
			str.append("\n\tItem " + (i) + ": " + 
					itm.getItemName());
			i++;
		}
		str.append("\n\n\n");
		return str.toString();
	}
}
