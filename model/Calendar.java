package model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;




public class Calendar {
	
	private Collection<Auction> myAuctionList;
	private int nextAuctionID;
	
	public Calendar(Collection<Auction> theAuction) {
		myAuctionList = theAuction;
		nextAuctionID = 1;
	}
	
	public Calendar() {
		myAuctionList = new ArrayList<Auction>();
	}
	
	// didn't catch the BR : no more than 2 auctions per day.
	public boolean addAuction(NPO theNPO, LocalDateTime theDate, int numItems, String theNotes) {
		// if the NPO already has the auction, throw error
		int auctions = 0;
		if(!theNPO.hasAuction() && theNPO.isValidAuctionDate(theDate) && myAuctionList.size() < 25){
			for (Auction a : myAuctionList)
			{
				if(a.getAuctionDate().toLocalDate().isEqual(theDate.toLocalDate()))
					auctions++;
			}
			if (auctions < 2)
			{
				Auction newAuction = new Auction(theNPO, theDate, numItems, theNotes, nextAuctionID);
				myAuctionList.add(newAuction);
				theNPO.setAuction(true);
				theNPO.setLastAuctionDate(theDate);
				nextAuctionID++;
				return true;
			}
//			System.out.println("ERROR: You already have an auction."
//					+ " You are only allowed one auction at a time");
		} 
		return false;
	}
	
	public boolean requestBid(Bidder theBidder, int theItemID, double theBidAmount, int theAuctionID)
	{
		for (Auction a : myAuctionList)
		{
			if (a.getMyID() == theAuctionID)
			{
				if (a.getItem(theItemID).isValidBid(theBidAmount))
				{
					theBidder.addBid(new Bid(theBidder.getMyName(), theItemID, theBidAmount, theAuctionID));
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public Collection<Auction> getAuctionsAfterThisDate(AuctionDate theDate) {
		//returnList contain all the auctions after the pass in date
		Collection<Auction> returnList = new ArrayList<Auction>();
		for (Auction curAuction : myAuctionList){
//			if (curAuction.getAuctionDate().isAfterThisDate(theDate)){
//				returnList.add(curAuction);
//			}
		}
		return returnList;
	}
	
	public Collection<Auction> getAllAuctions() {
		return myAuctionList;		
	}
	
	public Auction getAuction(NPO theNPO)
	{
		Auction auction = null;
		for (Auction a : myAuctionList)
		{
			if (a.getNPO() == theNPO)
				auction = a;
		}
		return auction;
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
	
	public int getAuctionDayCount(LocalDate theDate)
	{
		int count = 0;
		for (Auction a : myAuctionList)
		{
			if(a.getAuctionDate().toLocalDate().isEqual(theDate))
				count++;
		}
		return count;
	}
	
/*	public boolean hasAuction(String NPO){
		return true;
	}*/
}
