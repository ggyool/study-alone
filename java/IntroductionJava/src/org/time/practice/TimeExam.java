package org.time.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExam {
	
	public static void main(String[] args) {
		/* 
			2019-11-19T16:27:07.896
			2019-11-19
			NOVEMBER
			11
			16
			2012-12-12
			10:15:30
		 */
		LocalDateTime timePoint = LocalDateTime.now();
		System.out.println(timePoint);
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);
		System.out.println(timePoint.getMonth());
		System.out.println(timePoint.getMonthValue());
		System.out.println(timePoint.getHour());
		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
		System.out.println(ld1);
		LocalTime lt1 = LocalTime.of(17,18);
		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);
	}
}
