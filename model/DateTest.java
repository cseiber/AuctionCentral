package model;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;
import java.time.YearMonth;

public class DateTest {

	public static void main(String[] args) {
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
			if ((count < 7 && count < dayOfWeek % 7) || count >= numDays)
				days[count][0] = 0;
			else
			{
				days[count][0] = i;
				if (i >= numDays)
					i = 0;
			}
			count++;
		}
		for (int[] a : days)
		{
			System.out.println(a[0]);
		}
		
		count = 0;
		System.out.println("    Su\t      M\t       T\tW\tTh\t  F\t   Sa");
		for (int i = 0; i < 35; i++)
		{
			int day = days[i][0];
			if (day == 0)
				sb.append("|    :   ");
			else
			{
				if (day < 10)
					sb.append("| 0" + day + " :   ");
				else
					sb.append("| " + day + " :   ");
			}
			if (i%7 == 6)
			{
				sb.append("|");
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		}
		//System.out.println(days);
		//System.out.println(curDay);
//		System.out.println("   Su\t   M\t   T\t   W\t   Th\t   F\t   Sa");
//		System.out.println("| " + days[0][0] + :"|\t|\t|\t|\t|\t|\t|");
//		System.out.println("|\t|\t|\t|\t|\t|\t|\t|");
//		System.out.println("|\t|\t|\t|\t|\t|\t|\t|");
//		System.out.println("|\t|\t|\t|\t|\t|\t|\t|");
//		System.out.println("|\t|\t|\t|\t|\t|\t|\t|");
//		// TODO Auto-generated method stub
//		LocalDateTime time = LocalDateTime.now();
//		LocalDateTime otherTime = LocalDateTime.of(2016, 11, 11, 01, 0);
//		System.out.println(time.toLocalDate().equals(otherTime.toLocalDate()));
//		Period timeDiff = Period.between(time.toLocalDate(), otherTime.toLocalDate());
//		//System.out.println(timeDiff.getMonths());
//		
//		//System.out.println(time.toString());

	}

}
