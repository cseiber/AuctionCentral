package model;


import java.util.ArrayList;
import java.util.Collection;




public class Calendar {
	
	private Collection<Auction> myAuctionList;
	
	public Calendar() {
		myAuctionList = new ArrayList<Auction>();
	}
	
	// didn't catch the BR : no more than 2 auctions per day.
	public void addAuction(Auction theAuction) {
		// if the NPO already has the auction, throw error
		if(theAuction.getNPO().hasAuction()){
			System.out.println("ERROR: You already have an auction."
					+ " You are only allowed one auction at a time");
		} else{
			myAuctionList.add(theAuction);
			theAuction.getNPO().setAuction(theAuction);
			theAuction.getNPO().setAuction(true);
		}
	}
	
	
	public Collection<Auction> getAuctionsAfterThisDate(AuctionDate theDate) {
		//returnList contain all the auctions after the pass in date
		Collection<Auction> returnList = new ArrayList<Auction>();
		for (Auction curAuction : myAuctionList){
			if (curAuction.getAuctionDate().isAfterThisDate(theDate)){
				returnList.add(curAuction);
			}
		}
		return returnList;
	}
	
	public Collection<Auction> getAllAuctions() {
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
}
