package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
//import java.util.Calendar;
import java.util.Scanner;

import model.Calendar;
import model.Staff;

public class StaffUI {

	static Staff curStaff;
	static Calendar myCalendar;
	static Scanner sc = new Scanner(System.in);
	static int choice;

	StaffUI() {
	}

	public static void welcomeScreen(Staff theUser, Calendar theCalendar) {
		curStaff = theUser;
		myCalendar = theCalendar;
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
		StringBuilder sb = new StringBuilder();
		YearMonth now = YearMonth.now();
		LocalDate date;
		boolean nextMonth = false;
		int numDays = now.lengthOfMonth();
		int[][] days = new int[35][2];
		int curDay = LocalDateTime.now().getDayOfMonth();
		int dayOfWeek = LocalDateTime.now().getDayOfWeek().getValue();
		//System.out.println((dayOfWeek)%7);
		int count = 0;
		for (int i = curDay; count < 35; i++ )
		{
			if ((count < 7 && count < dayOfWeek % 7 + 1) || count > numDays)
				days[count][0] = 0;
			else
			{
				if (!nextMonth)
					date = LocalDate.of(now.getYear(), now.getMonthValue(), i);
				else
					date = LocalDate.of(now.getYear(), now.getMonthValue() + 1, i);
				
				days[count][0] = i;
				days[count][1] = myCalendar.getAuctionDayCount(date);
				if (i >= numDays)
				{
					i = 0;
					nextMonth = true;
				}
			}
			count++;
		}
		
		count = 0;
		System.out.println("    Su\t      M\t       T\tW\tTh\t  F\t   Sa");
		for (int i = 0; i < 35; i++)
		{
			int day = days[i][0];
			int auctions = days[i][1];
			if (day == 0)
				sb.append("|    :   ");
			else
			{
				if (day < 10)
					sb.append("| 0" + day + " : " + auctions + " ");
				else
					sb.append("| " + day + " : " + auctions + " ");
			}
			if (i%7 == 6)
			{
				sb.append("|");
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		}

	}
	
}
