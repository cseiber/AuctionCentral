package model;
//match
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * user object 
 * @author Seiber, Tran, Gillet, Fitzgerald, Wiklanski
 * @version 11/14/2016 
 */
public class User implements Serializable {
	
	//attributes 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2557293527731096827L;

	String myUserName;
	
	String myName;
	
	String myUserType;
	
	public User() {};
	/**
	 * this constructs a user with a user name, name and type of user
	 * @param theUserName
	 * @param theName
	 * @param theUserType
	 */
	public User(String theUserName, String theName, String theUserType) {
		myUserName = theUserName;
		myName = theName;
		myUserType = theUserType;
	}
	/**
	 * this constructs a user with a user name
	 * @param theUserName
	 * @param theName
	 */
	public User(String theUserName, String theName) {
		myUserName = theUserName;
		myName = theName;
	}
	/**
	 * isEqual test to see if the user is 
	 * @param theUser
	 * @return
	 */
	public boolean isEqual(User theUser){
		return myUserName.equals(theUser.getMyUserName());
	}
	/**
	 * 
	 * @return the type of user the user is, NOP, Staff, or Bidder
	 */
	public String getUserType(){return myUserType;}
    /**
     * 
     * @return 
     */
	public String getMyUserName() {return myUserName;}
	
	public String getMyName() {return myName;}

//	public void setUserType(String theUserType){
//		this.myUserType = theUserType;
//	}
	
	public void setMyUserName(String myUserName) {
		this.myUserName = myUserName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	
}
