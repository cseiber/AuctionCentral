package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Period;

public class NPO extends User implements Serializable{
	private boolean hasAuction;
	LocalDateTime lastAuctionDate;
	

	public NPO(String theUserName, String theName){
		super(theUserName, theName, "NPO");
		hasAuction = false;
		lastAuctionDate = LocalDateTime.of(1970, 1, 1, 12, 00); //Default initializer
	}
	
	public void setAuction(boolean x){
		hasAuction = x;
	}
		
	public LocalDateTime getLastAuctionDate() {
		return lastAuctionDate;
	}

	public void setLastAuctionDate(LocalDateTime lastAuctionDate) {
		this.lastAuctionDate = lastAuctionDate;
	}
	
	public boolean hasAuction(){
		return hasAuction;
	}
	
//	public boolean auctionRequest(LocalDateTime theTime, int itemNumber){
//		
//		if (hasAuction || !isValidAuctionDate(theTime)){
//			return false;
//		}
//		//send request here (could return false still)
//		return true;
//	}
	
	public boolean isValidAuctionDate(LocalDateTime theAuctionDate){
		LocalDateTime now = LocalDateTime.now();
		Period prevAuctionTime = Period.between(lastAuctionDate.toLocalDate(), theAuctionDate.toLocalDate());
		Period futureTimes = Period.between(now.toLocalDate(), theAuctionDate.toLocalDate());
		
		if (prevAuctionTime.getYears() < 1)
		{
			return false;
		}
		if (futureTimes.getMonths() > 1)
		{			
			return false;
		}
		else if (futureTimes.getMonths() == 1)
		{
			if (now.getDayOfMonth() < theAuctionDate.getDayOfMonth())
				return false;
		}
		else if (futureTimes.getDays() < 7)
				return false;
		
			return true;
		
	}
		
}
