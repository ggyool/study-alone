package org.calendar.practice;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExam {
	public static void main(String[] args) {
		// Calendar�� �߻�Ŭ����
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.get(Calendar.YEAR));
		// MONTH�� 0�� ���ͼ��� 1���ؾ� �Ѵ�.
		System.out.println(cal.get(Calendar.MONTH) +1 );
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		// �ټ� �ð� �ķ� �ٲٱ�
		cal.add(Calendar.HOUR, 5);
	}
}
