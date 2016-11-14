package model;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;
import java.time.YearMonth;

public class DateTest {

	public static void main(String[] args) {
		char ch;

		ch = (char) ((25) + 'a');
		System.out.println(ch); 
	}
	
	public void calendarTest()
	{
		StringBuilder sb = new StringBuilder();
		YearMonth now = YearMonth.now();
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
				days[count][0] = i;
				if (i >= numDays)
					i = 0;
			}
			days[count][1] = 1;
			count++;
		}
		
		//this is just testing to be sure the days are being stored properly
		for (int[] a : days)
		{
			System.out.println(a[0]);
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
