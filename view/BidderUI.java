package view;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//match
import java.util.Collection;
import java.util.Scanner;

import model.Auction;
import model.Bid;
import model.Bidder;
import model.Calendar;
import model.Item;

public class BidderUI {
	
	static Bidder currentBidder;
	static Calendar myCalendar;
	static Scanner sc = new Scanner(System.in);
	static int choice;
	static int EXIT = 1765456165;
	
	BidderUI(){
	}
	
	public static void welcomeScreen(Bidder bidder, Calendar theCalendar){
		
		choice = 0;
		currentBidder = bidder;
		myCalendar = theCalendar;
		
		System.out.println("You are now logged in as: " + currentBidder.getMyName());
		System.out.println("Welcome " + currentBidder.getMyName() + ", what would you like to do?");
		
		while (choice != 1 && choice != 2 && choice != 3 && choice != EXIT) {
			System.out.println("");
			
			System.out.println("1. View all upcoming auctions");
			System.out.println("2. View your active bids");
			System.out.println("3. Log out and return to main menu.");

			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				showAuctions();
				break;
			case 2:
				showBids();
				break;
			case 3:
				System.out.println("You have been logged out of the System");
				choice = EXIT;
				break;

			default:
				System.out.println("Please choose within the range provided");
			
			}
		}
	}
	public static void showAuctions() {

		choice = 0;
		System.out.println("");
		System.out.println("This is the list of Auctions");
		System.out.println("");

		for(Auction a : myCalendar.getAllAuctions()){
				
			System.out.println(a.toString());
		}		
		
		while (choice != 1 && choice != 2 && choice != 3 && choice != EXIT) {
			System.out.println("");
			System.out.println("What would you like to do?");
			System.out.println("");
			
			System.out.println("1. Bid on an item");
			System.out.println("2. View your active bids");
			System.out.println("3. Log out and return to main menu.");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
	
			case 1:
				makeBid();
				break;
			case 2:
				showBids();
				break;
			case 3:
				System.out.println("You have been logged out of the System");
				choice = EXIT;
				break;
	
			default:
				System.out.println("Please choose within the range provided");
			}
		}
	}

	public static void makeBid() {
		choice = 0;
		boolean found = false;
		int itemID;
		double bidOffer = 0;
		Auction thisAuct = null;
		System.out.println("");
		System.out.println("Enter the item number?");
		System.out.println(">>");
		itemID = sc.nextInt();
		
		for(Auction a : myCalendar.getAllAuctions()){
			for(Item i : a.getItemList()){
				if(i.getMyItemID() == itemID){
					System.out.println("Bidding on:");
					System.out.println("\nItem ID: \tName: \t\tMin Bid: \tCondition: \tdescription: ");
					System.out.println(a.getItem(itemID));
					thisAuct = a;
					found = true;
				}
			}
		}
		if(!found){
			System.out.println("Item not found");
			welcomeScreen(currentBidder, myCalendar);
		}
		
		
		System.out.println("");
		System.out.println("What is your bid?");
		System.out.println(">>");
		bidOffer = sc.nextDouble();
		
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != EXIT) {
			System.out.println("Your bid is " + bidOffer + " for "+ thisAuct.getItem(itemID).getItemName()+".");
			System.out.println("Please choose one of the following");
			System.out.println("");
			System.out.println("1. Confirm and place your bid");
			System.out.println("2. Cancel this bid");
			System.out.println("3. Cancel bid and return to main menu");
			System.out.println(">>");
			
			choice = sc.nextInt();
			switch (choice) {
	
			case 1:
				placeBid(thisAuct, bidOffer, itemID);
				break;
			case 2:
				System.out.println("Bid canceled");
				makeBid();
				break;
			case 3:
				welcomeScreen(currentBidder, myCalendar);
				break;
			case 4:
				System.out.println("You have been logged out of the System");
				choice = EXIT;
				break;
	
			default:
				System.out.println("Please choose within the range provided");
			}
		}
		
	}

	private static void placeBid(Auction a, double bidOffer, int itemID) {
		
		Bid myBid = new Bid(currentBidder.getMyUserName(), itemID, bidOffer, a.getMyID());
		
		if(a.getItem(itemID).isValidBid(bidOffer) && currentBidder.addBid(myBid)){
			
			currentBidder.placeBid(myBid);
			System.out.println("Congratulations! Your bid of $" + bidOffer + " for " + a.getItem(itemID).getItemName() + " has been placed.\n");
			welcomeScreen(currentBidder, myCalendar);
		}else{
			System.out.println("Sorry, invalid bid.");
			makeBid();
		}
	
	}

	public static void showBids() {
		choice = 0;

		
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != EXIT) {
			
			System.out.println("");
			System.out.println("Current bids for " + currentBidder.getMyName());
			
			System.out.println(currentBidder.printBids());
			
			System.out.println("What would you like to do?");
			System.out.println("Please choose one of the following");
			System.out.println("");
			System.out.println("1. View all upcoming auctions");
			System.out.println("2. View your active bids");
			System.out.println("3. Return to main menu.");
			System.out.println("4. Log out and return to main menu.");
			System.out.println(">>");
			
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				showAuctions();
				break;
			case 2:
				showBids();
				break;
			case 3:
				welcomeScreen(currentBidder, myCalendar);
				break;
			case 4:
				System.out.println("You have been logged out of the System");
				choice = EXIT;
				break;
			default:
				System.out.println("Please choose within the range provided");

			}
		}
	}
}















