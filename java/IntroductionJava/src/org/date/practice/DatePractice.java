package org.date.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePractice {
	public static void main(String[] args) {
		// Date �� ����ȭ�� ������� Ŭ����
		Date date = new Date();
		System.out.println(date.toString());
		// ���� ����     2019.11.18 at 06:37:28 ���� KST
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(ft.format(date));
		// long �ð� �Ʒ� �ΰ� ������
		System.out.println(date.getTime()); 
		long today = System.currentTimeMillis();
		System.out.println(today);
	}
}
