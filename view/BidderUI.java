package view;

import java.util.Collection;
import java.util.Scanner;

import model.Bid;
import model.Bidder;
/* The BidderUI class displays bidder options to navigate the system.
 * @author Seiber, Tran, Gillet, Fitzgerald, Wiklanski
 * @version 11/14/2016
 */
public class BidderUI {
	
	static Bidder currentBidder;
	static Scanner sc = new Scanner(System.in);
	static int choice;
	
	BidderUI()
	{
		
		
	}
	/**
	 * displays the welcome screen for a Bidder
	 * @param bidder
	 */
	public static void welcomeScreen(Bidder bidder){
				
		System.out.println("You are now logged in as: " + currentBidder.getMyName());
		System.out.println("Welcome " + currentBidder.getMyName() + ", what would you like to do?");
		while (choice != 1 && choice != 2) {
			System.out.println("");
			System.out.println("1. View all upcoming auctions");
			System.out.println("2. Log out and return to main menu.");
			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:	showAuctions(); break;
			case 2: System.out.println("You have been logged out of the System"); break;
			default: System.out.println("Please choose within the range provided");
			}
		}
	}
	/**
	 * prints list of available auctions to UI
	 */
	public static void showAuctions() {
		System.out.println("");
		System.out.println("This is the list of Auctions");

	}

}
