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
import model.User;

/**
 * @author phuc tran
 *
 */
public class main {
	
	private static Calendar myCalendar;
	Scanner sc = new Scanner(System.in);
	private Collection<User> userList;
	User curUser;
	int choice;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection <Auction> auctionList = deSerializeAuction();
		Collection <User> userList = deSerializeUser();
		
		myCalendar = new Calendar(auctionList);

		System.out.println(((ArrayList<Auction>)myCalendar.getAllAuctions()).get(1).toString());

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
		System.out.println("Welcome to Auction Central");
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
		default: System.err.println("Please choose within the range provided"); welcomeScreen();
		}
	}
	
	public void loginScreen()
	{
		System.out.println("Auction Central Log In");
		System.out.println("");
		System.out.println("Please enter your user name below");
		System.out.println("");
		System.out.println("");
		System.out.println(">>");
		String userName = sc.nextLine();
		
		for (User u : userList)
		{
			if (u.getMyUserName() == userName)
				curUser = u;
		}
		if (curUser == null)
		{
			System.err.println("User not found");
			System.out.println("1. Try again");
			System.out.println("2. Register");
			choice = sc.nextInt();
			switch (choice) {
			case 1:	loginScreen();
			case 2: registrationScreen();
			case 3: System.exit(0);
			default: System.err.println("Please choose within the range provided"); welcomeScreen();
			}
		}
		
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
