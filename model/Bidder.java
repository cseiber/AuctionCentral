package model;

import java.io.Serializable;
import java.util.Collection;

public class Bidder extends User implements Serializable{

	private String myAddress;
	private String myPhone;
	private String myEmail;
	private String myPaymentInfo;
	private Collection<Bid> myBids;

	Bidder(String theUserName, String theName, String theAddress, String thePhone, String theEmail, String thePaymentInfo)
	{
		super(theUserName, theName, "Bidder");
		myAddress = theAddress;
		myPhone = thePhone;
		myEmail = theEmail;
		myPaymentInfo = thePaymentInfo;		
	}
	
	/**
	 * @return the myAddress
	 */
	public String getMyAddress() {
		return myAddress;
	}

	/**
	 * @param myAddress the myAddress to set
	 */
	public void setMyAddress(String myAddress) {
		this.myAddress = myAddress;
	}

	/**
	 * @return the myPhone
	 */
	public String getMyPhone() {
		return myPhone;
	}

	/**
	 * @param myPhone the myPhone to set
	 */
	public void setMyPhone(String myPhone) {
		this.myPhone = myPhone;
	}

	/**
	 * @return the myEmail
	 */
	public String getMyEmail() {
		return myEmail;
	}

	/**
	 * @param myEmail the myEmail to set
	 */
	public void setMyEmail(String myEmail) {
		this.myEmail = myEmail;
	}

	/**
	 * @return the myPaymentInfo
	 */
	public String getMyPaymentInfo() {
		return myPaymentInfo;
	}

	/**
	 * @param myPaymentInfo the myPaymentInfo to set
	 */
	public void setMyPaymentInfo(String myPaymentInfo) {
		this.myPaymentInfo = myPaymentInfo;
	}	
	
	/**
	 * @return the myBids
	 */
	public Collection<Bid> getMyBids() {
		return myBids;
	}

	/**
	 * @param myBid the Bid to set
	 */
	public boolean addBid(Bid myBid) {
		for (Bid b : myBids)
		{
			if (b.getMyItemID() == myBid.getMyItemID())
				return false;
		}
		myBids.add(myBid);
		return true;
	}

}
