package view;

import java.time.LocalDateTime;
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
				if (curNPO.hasAuction()) {
					System.out.println(
							"I am sorry but our records show you currently have an auction scheduled, you can only"
									+ " have one auction scheduled at a time. Please select another operation.");
				} else
					auctionRequestScreen();
				break;
			case 2:
				if (!curNPO.hasAuction()) {
					System.out.println(
							"I am sorry but our records show you currently do not have an auction scheduled, please submit an auction request to begin the "
									+ "process of scheduling an auction");
				} else
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
				if (curNPO.hasAuction()) {
					System.out.println(
							"I am sorry but our records show you currently have an auction scheduled, you can only"
									+ " have one auction scheduled at a time. Please select another operation.");
				} else
					auctionRequestScreen();
				break;
			case 2:
				if (!curNPO.hasAuction()) {
					System.out.println(
							"I am sorry but our records show you currently do not have an auction scheduled, please submit an auction request to begin the "
									+ "process of scheduling an auction");
				} else
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

	// addAuction(NPO theNPO, LocalDateTime theDate, int numItems, String
	// theNotes)
	public static void auctionRequestScreen() {
		choice = 0;
		System.out.println("Auction Central NPO Auction Requests");
		System.out.println("You are logged in as: " + curNPO.getMyName());
		System.out.println("");
		System.out.println("Welcome " + curNPO.getMyName()
				+ ", Would like to enter the number of items or general notes about this auction? (y/n)");
		String ans = sc.next();
		String notes = "";
		int items = 0;
		if (ans.equals("y")) {
			System.out.println("How many items do you plan on auctioning?");
			items = sc.nextInt();
			System.out.println("");
			System.out.println("What notes would you like to add to the auction record?");
			notes = sc.next();
		}
		System.out.println("");
		while (choice != 1 && choice != 2  && choice != 3) {
			System.out.println("Please enter the following information about when you would like the auction");
			System.out.println("");
			System.out.println("The Year (ex: 2015): ");
			int year = sc.nextInt();
			System.out.println("The month (ex: for May type '5'): ");
			int month = sc.nextInt();
			System.out.println("The day (ex: 15): ");
			int day = sc.nextInt();
			System.out.println("The time (on the hour please in 24 hour format, (ex: for 4pm type 16): ");
			int hour = sc.nextInt();
			LocalDateTime auctionDate = LocalDateTime.of(year, month, day, hour, 0);
			System.out.println("");
			System.out.println("You entered the following information:");
			System.out.println("Auction Date: " + auctionDate.toString());
			System.out.println("Number of Items:" + items);
			System.out.println("Notes: " + notes);
			
			System.out.println("1. Looks good! Please submit my request");
			System.out.println("2. Change Auction information");
			System.out.println("3. Cancel request and return to the NPO Main Menu.");
			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (myCalendar.addAuction(curNPO, auctionDate, items, notes))
					auctionCreatedScreen();
				else
					System.out.println("I am sorry but the date you entered is not available, please choose a new date.");
				break;
			case 2:
				auctionRequestScreen();
				break;
			case 3:
				welcomeScreen();
				break;
			default:
				System.out.println("Please choose within the range provided!");
			}
		}
	}
	
	public static void auctionCreatedScreen()
	{
		choice = 0;
		System.out.println("Auction Central auction Sucess View");
		System.out.println("You are logged in as: " + curNPO.getMyName());
		System.out.println("Congratulations " + curNPO.getMyName() + "!, your auction was successfully created");
		System.out.println("");
		System.out.println("What would you like to do now " + curNPO.getMyName() + "?");
		while (choice != 1 && choice != 2) {
			System.out.println("");
			System.out.println("1. Add an item to my upcoming auction");
			System.out.println("2. Return to the NPO Main Menu..");
			System.out.println("");
			System.out.println(">>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (!curNPO.hasAuction()) {
					System.out.println(
							"I am sorry but our records show you currently do not have an auction scheduled, please submit an auction request to begin the "
									+ "process of scheduling an auction");
				} else
					addItemScreen();
				break;
			case 2:
				welcomeScreen();
				break;
			default:
				System.out.println("Please choose within the range provided!");
			}
		}
	}

	public static void addItemScreen() {
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
