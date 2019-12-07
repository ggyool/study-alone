package org.wrapper.pack;

public class WrapperPractice {
	public static void main(String[] args) {
		int a = 10;
		// Wrapper Class
		// Integer, Boolean etc...
		Integer b = new Integer(20);
		Integer c = 30; // 오토 박싱 - new 없이 저절로
		int d = b; // 오토 언박싱 (저절로 intValue())
		
		System.out.println(a);
		System.out.println(b.intValue());
		System.out.println(b);
	}
}
