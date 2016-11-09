package model;



public class NPO extends User{
	private boolean hasAuction;
	private Auction myAuction;
	public NPO(String theUserName, String theName){
		super(theUserName, theName);
		hasAuction = false;
	}
	
	public void setAuction(Auction theAuction){
		myAuction = theAuction;
	}
	
	public void setAuction(boolean x){
		hasAuction = x;
	}
	
	
	public boolean hasAuction(){
		return hasAuction;
	}
	
	public boolean auctionRequest(){
		if (hasAuction){
			return false;
		}
		return true;
	}
	
	public Boolean getLastAuctionDate(Auction theAuction){
		if (theAuction.getNPO().getMyUserName().equals(this.getMyUserName())
				|| !(hasAuction)){
			if((theAuction.getAuctionDate().getYear() - myAuction.getAuctionDate().getYear()> 1)){
				return true;
			} else if (theAuction.getAuctionDate().getYear() - myAuction.getAuctionDate().getYear()== 1
				&& theAuction.getAuctionDate().getMonth()>= myAuction.getAuctionDate().getMonth()){
				return true;				
			} else if (theAuction.getAuctionDate().getYear() - myAuction.getAuctionDate().getYear()== 1
					&& theAuction.getAuctionDate().getMonth()>= myAuction.getAuctionDate().getMonth()
					&& theAuction.getAuctionDate().getDate() >= myAuction.getAuctionDate().getDate()){
				return true;
			} else{
				return false;
			}
			
		}
		return null;
		
	}
		
}
