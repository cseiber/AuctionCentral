package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;



public class Calendar {
	
	private Collection<Auction> myAuctionList;
	
	private int myTotalAuctions;
	

	public Calendar() {
		myAuctionList = new ArrayList<Auction>();
	}
	
	// just don't worry about NullPointer exception for now
	public boolean addAuction(Auction theAuction) {
		// if the NPO already has the auction, throw error
		if(theAuction.getNPO().hasAuction()){
			//System.out.println("ERROR: You already have an auction. You are only allowed one auction at a time");
			return false; 
		} else{
			myAuctionList.add(theAuction);
			theAuction.getNPO().setAuction(true);
		}
		return true;
	}
	
/*	@Test
	public void addAuctionTest(){
		NPO a = new NPO("NPOa", "a");
		Auction theAuction = new Auction(a, 3);
		
		//expected the size of auction list = 0
		// and the NPO hasAuction() = FALSE
		assertEquals(0, myAuctionList.size(), 0.0);
		assertFalse(theAuction.getNPO().hasAuction());
		
		addAuction(theAuction);
		// expected the size of auction list = 1 (after add)
		// NPO hasAuction() = TRUE
		// Note*: change the expected value in assertEquals method to experience the Unit test
		assertEquals(1, myAuctionList.size(), 0.0);	
		assertTrue(theAuction.getNPO().hasAuction());

	}*/
	
	public Collection<Auction> getAuctions(Date theDate) {
		return myAuctionList;		
	}
	
	public Collection<Auction> getAuctions() {
		return myAuctionList;		
	}
	
//	public boolean updateAuction(String theNPO){
//		return false;		
//	}
	
	public boolean deleteAuction(String NPO){
		for (Auction a : myAuctionList)
		{
			if (a.getNPO().getMyName() == NPO)
			{
				a.getNPO().setAuction(false);
				myAuctionList.remove(a);
				return true;
			}
		}
		return false;
	}
	
/*	public boolean hasAuction(String NPO){
		return true;
	}*/
	
	public static void main(String [] args){
		Calendar myCalendar = new Calendar();
		NPO a = new NPO("AaronG", "Aaron");
		NPO b = new NPO("CarlS", "Carl");
		
		Auction x = new Auction(a, 3);
		Auction y = new Auction(b, 2);
		
		x.addItem(new Item("chocolate"));
		x.addItem(new Item("candy"));
		x.addItem(new Item("donut"));
		
		y.addItem(new Item("car"));
		y.addItem(new Item("truck"));
		
		myCalendar.addAuction(x);
		myCalendar.addAuction(y);
		
		System.out.println("Auction info NPO for: " + a.getMyName());
		x.toString();
		System.out.println();
		System.out.println("Auction info NPO y for: "+ b.getMyName());
		y.toString();
		
		System.out.println();
		
		//print test for add more auction on NPO a
		myCalendar.addAuction(new Auction(a,3));
		
	}
}
