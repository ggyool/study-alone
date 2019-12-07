package org.string.buffer;

public class InputTest {
	public static void main(String[] args) {
		long startTime, endTime;
		// 문자열에 계속 붙여나갈 경우
		startTime = System.currentTimeMillis();
		String s1 = "";
		for(int i=0; i<100000; ++i) {
			s1 = s1 + '*';
		}
		//System.out.println(s1);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// 위 의동작은 대충 아래와 같다
		startTime = System.currentTimeMillis();
		String s2 = "";
		for(int i=0; i<100000; ++i)
		{
			s2 = new StringBuffer(s2).append('*').toString();
		}
		//System.out.println(s2);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// 아래 처럼 하는게 좋다.
		startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<100000; ++i)
		{
			sb.append('*');
		}
		String s3 = sb.toString();
		//System.out.println(s3);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
