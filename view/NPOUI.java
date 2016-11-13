package view;

import java.util.Scanner;

import model.Calendar;
import model.NPO;
import model.Staff;

public class NPOUI {
	
	static Calendar myCalendar;
	static NPO curNPO;
	static Scanner sc = new Scanner(System.in);
	static int choice;


	NPOUI() {		
	}
	
	public static void welcomeScreen(NPO theUser, Calendar theCalendar) {
		curNPO = theUser;
		myCalendar = theCalendar;
		System.out.println("Auction Central Main NPO View");
		System.out.println("You are logged in as: " + curNPO.getMyName());
		System.out.println("Welcome " + curNPO.getMyName() + ", what would you like to do?");
		while (choice != 1 && choice != 2) {
			System.out.println("");
			System.out.println("1. Submit an auction request");
			System.out.println("2. Add an item to my upcoming auction");
			System.out.println("3. Log out and return to main menu.");
			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				auctionRequestScreen();
				break;
			case 2:
				System.out.println("You have been logged out of the System");
				break;
			default:
				System.out.println("Please choose within the range provided!");
			}
		}
	}
	
	private static void welcomeScreen() {
		choice = 0;
		System.out.println("Auction Central Main NPO View");
		System.out.println("You are logged in as: " + curNPO.getMyName());
		System.out.println("Welcome " + curNPO.getMyName() + ", what would you like to do?");
		while (choice != 1 && choice != 2 && choice != 3) {
			System.out.println("");
			System.out.println("1. Submit an auction request");
			System.out.println("2. Add an item to my upcoming auction");
			System.out.println("3. Log out and return to main menu.");
			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (curNPO.hasAuction())
				{
					System.out.println("I am sorry but our records show you currently have an auction scheduled, you can only"
							+ " have one auction scheduled at a time. Please select another operation.");
				}
				else
					auctionRequestScreen();
				break;
			case 2:
				if (!curNPO.hasAuction())
				{
					System.out.println("I am sorry but our records show you currently do not have an auction scheduled, please submit an auction request to begin the "
							+ "process of scheduling an auction");
				}
				else
					addItemScreen();
				break;
			case 3:
				System.out.println("You have been logged out of the System");
				break;
			default:
				System.out.println("Please choose within the range provided!");
			}
		}
	}
	
	public static void auctionRequestScreen()
	{
		choice = 0;
		System.out.println("Auction Central NPO Auction Requests");
		System.out.println("You are logged in as: " + curNPO.getMyName());
		System.out.println("Welcome " + curNPO.getMyName() + ", what would you like to do?");
		while (choice != 1 && choice != 2) {
			System.out.println("");
			System.out.println("1. Submit an auction request");
			System.out.println("2. Add an item to my upcoming auction");
			System.out.println("3. Log out and return to main menu.");
			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				auctionRequestScreen();
				break;
			case 2:
				System.out.println("You have been logged out of the System");
				break;
			default:
				System.out.println("Please choose within the range provided!");
			}
		}
	}
	
	public static void addItemScreen()
	{
		choice = 0;
		System.out.println("Auction Central NPO add inventory");
		System.out.println("You are logged in as: " + curNPO.getMyName());
		System.out.println("Welcome " + curNPO.getMyName() + ", what would you like to do?");
		while (choice != 1 && choice != 2) {
			System.out.println("");
			System.out.println("1. Submit an auction request");
			System.out.println("2. Add an item to my upcoming auction");
			System.out.println("3. Log out and return to main menu.");
			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				auctionRequestScreen();
				break;
			case 2:
				System.out.println("You have been logged out of the System");
				break;
			default:
				System.out.println("Please choose within the range provided!");
			}
		}
	}

}
