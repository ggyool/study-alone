package org.calendar.practice;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExam {
	public static void main(String[] args) {
		// Calendar는 추상클래스
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.get(Calendar.YEAR));
		// MONTH는 0월 부터세서 1더해야 한다.
		System.out.println(cal.get(Calendar.MONTH) +1 );
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		// 다섯 시간 후로 바꾸기
		cal.add(Calendar.HOUR, 5);
	}
}
