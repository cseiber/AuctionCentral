package model;

public class User {
	
	//attributes 
	
	String myUserName;
	
	String myName;
	
	public User(String theUserName, String theName) {
		myUserName = theUserName;
		myName = theName;
	}

	public String getMyUserName() {
		return myUserName;
	}

	public void setMyUserName(String myUserName) {
		this.myUserName = myUserName;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	
}
