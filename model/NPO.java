package model;



public class NPO extends User{
	private boolean hasAuction;
	public NPO(String theUserName, String theName){
		super(theUserName, theName);
		hasAuction = false;
	}
	
	public void setAuction(boolean x){
		hasAuction = x;
	}
	
	
	public boolean hasAuction(){
		return hasAuction;
	}
		
}
