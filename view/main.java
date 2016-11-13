/**
 * 
 */
package view;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import model.Auction;
import model.AuctionDate;
import model.Calendar;
import model.Item;
import model.NPO;
import model.Staff;
import model.User;

/**
 * @author phuc tran
 *
 */
public class main {
	
	private static Calendar myCalendar;
	Scanner sc = new Scanner(System.in);
	private ArrayList<User> userList  = new ArrayList();
	User curUser = new User();
	int choice;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		main UI = new main();
		
		UI.welcomeScreen();
		
//		Collection <Auction> auctionList = deSerializeAuction();
//		Collection <User> userList = deSerializeUser();
//		
//		myCalendar = new Calendar(auctionList);
//
//		System.out.println(((ArrayList<Auction>)myCalendar.getAllAuctions()).get(1).toString());

	}
	
	@SuppressWarnings("unchecked")
	public static Collection<Auction> deSerializeAuction(){
		Collection<Auction> AuctionList = new ArrayList<Auction>();
		try{
			
			FileInputStream fileIn = new FileInputStream("auctionlist.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        AuctionList = (Collection<Auction>) in.readObject();
	        in.close();
	        fileIn.close();
		}catch(IOException i){
			System.out.println("NPO class not found");
	        i.printStackTrace();
	        return null;
		}catch(ClassNotFoundException c){
			System.out.println("NPO class not found");
	        c.printStackTrace();
	        return null;
		}
		return AuctionList;
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<User> deSerializeUser(){
		Collection<User> UserList = new ArrayList<User>();
		try{
			
			FileInputStream fileIn = new FileInputStream("/Users/phucv/Documents/GitHub/AuctionCentral/userlist.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        UserList = (Collection<User>) in.readObject();
	        in.close();
	        fileIn.close();
		}catch(IOException i){
			System.out.println("NPO class not found");
	        i.printStackTrace();
	        return null;
		}catch(ClassNotFoundException c){
			System.out.println("NPO class not found");
	        c.printStackTrace();
	        return null;
		}
		return UserList;
	}
	
	public void welcomeScreen()
	{
		System.out.println("\n\nWelcome to Auction Central");
		System.out.println("Please enter a number from the following options below:");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("1. Log In");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("");
		System.out.println(">>");
		choice = sc.nextInt();
		
		switch (choice) {
		case 1:	loginScreen();
		case 2: registrationScreen();
		case 3: System.exit(0);
		default: System.out.println("Please choose within the range provided"); welcomeScreen();
		}
	}
	
	public void loginScreen()
	{
		System.out.println("\n\nAuction Central Log In");
		System.out.println("");
		System.out.println("Please enter your user name below");
		System.out.println("");
		System.out.println("");
		System.out.println(">>");
		String userName = sc.next();
		
		for (User u : userList)
		{
			System.out.println(u.getMyUserName().equals(userName));
			if (u.getMyUserName().equals(userName))
				curUser = u;
		}
		
		if (curUser.getMyUserName() == null)
		{
			System.out.println("User not found");
			System.out.println("");
			while (true)
			{
				System.out.println("1. Try again");
				System.out.println("2. Register");
				System.out.println("3. Main Menu");
				System.out.println(">>");
				
				choice = sc.nextInt();
				switch (choice) {
				case 1:	loginScreen();
				case 2: registrationScreen();
				case 3: welcomeScreen();
				default: System.out.println("Please choose within the range provided");
				}
			}
		}
		
	}
	
	public void registrationScreen()
	{
		System.out.println("\n\nAuction Central Registration");
		System.out.println("");
		System.out.println("What type of user do you want to register as?");
		System.out.println("");
		while (true)
		{
			System.out.println("1. Register as Auction Central Staff member");
			System.out.println("2. Register as a Non Profit Representative");
			System.out.println("3. Register as a Bidder");
			System.out.println("4. Back to Main Menu");
			choice = sc.nextInt();
			switch (choice) {
			case 1:	registerStaffScreen();
//			case 2: registerNPOScreen();
//			case 3: registerBidderScreen();
			case 4: welcomeScreen();
			default: System.out.println("Please choose within the range provided");
			}
		}
	}
	
	public void registerStaffScreen()
	{
		System.out.println("\n\nWelcome to Auction Central Staff Registration");
		System.out.println("Please enter your information below");
		System.out.println("");
		System.out.println("Enter a user name: ");
		String uName = sc.next();
		System.out.println("Enter your name: ");
		String name = sc.next();
		System.out.println("You have entered the following information");
		System.out.println("\tUsername: " + uName);
		System.out.println("\tName:\t" + name);
		System.out.println("Is this corrent?");
		while (true)
		{
			System.out.println("");
			System.out.println("1. Yes please register me");
			System.out.println("2. No, Try again");
			System.out.println("3. Main Menu");
			choice = sc.nextInt();
			switch (choice) {
			case 1:	registrationCompleteStaffScreen(uName, name);
			case 2: registrationScreen();
			case 3: welcomeScreen();
			default: System.out.println("Please choose within the range provided");
			}
		}
	}
	
	public void registrationCompleteStaffScreen(String userName, String name)
	{
		userList.add(new Staff(userName.trim(), name.trim()));
		System.out.println("\n\nCongratulations you have successfully registered on Auction Central");
		welcomeScreen();
	}
	
	
	
	
//	public static void printDate(){
//		Item myItem1 = new Item("Banana", "Good", "Small", 15);
//		Item myItem2 = new Item("Banana", "Good", "Small", 15);
//		Item myItem3 = new Item("Bandadsadas", "Good", "Small", 15);
//		System.out.println(myItem1.isEqual(myItem2));
//		System.out.println(myItem1.isEqual(myItem3));
//	}
//	
//	
//	public static void viewCalendar(){
//		setup();
//		AuctionDate date = new AuctionDate(2016,11,3);
//		ArrayList<Auction> printList = (ArrayList<Auction>) myCalendar.getAuctionsAfterThisDate(date);
//		for(Auction a : printList){
//			System.out.println("--------------------");
//			System.out.println(a.toString());
//		}
//	}

}
