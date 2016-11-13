package view;

import java.util.Scanner;

import model.Staff;

public class StaffUI {

	static Staff curStaff;
	static Scanner sc = new Scanner(System.in);
	static int choice;

	StaffUI() {
	}

	public static void welcomeScreen(Staff theUser) {
		curStaff = theUser;
		System.out.println("You are now logged in as: " + curStaff.getMyName());
		System.out.println("Welcome " + curStaff.getMyName() + ", what would you like to do?");
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

	public static void showAuctions() {
		System.out.println("");
		System.out.println("This is the list of Auctions");

	}
}
