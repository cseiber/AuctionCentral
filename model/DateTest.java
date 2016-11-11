package model;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime time = LocalDateTime.now();
		LocalDateTime otherTime = LocalDateTime.of(2016, 11, 11, 01, 0);
		System.out.println(time.toLocalDate().equals(otherTime.toLocalDate()));
		Period timeDiff = Period.between(time.toLocalDate(), otherTime.toLocalDate());
		//System.out.println(timeDiff.getMonths());
		
		//System.out.println(time.toString());

	}

}
