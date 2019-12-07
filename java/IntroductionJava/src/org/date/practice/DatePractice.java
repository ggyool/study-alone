package org.date.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePractice {
	public static void main(String[] args) {
		// Date 는 지역화를 고려안한 클래스
		Date date = new Date();
		System.out.println(date.toString());
		// 서식 지정     2019.11.18 at 06:37:28 오후 KST
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(ft.format(date));
		// long 시간 아래 두개 같은듯
		System.out.println(date.getTime()); 
		long today = System.currentTimeMillis();
		System.out.println(today);
	}
}
