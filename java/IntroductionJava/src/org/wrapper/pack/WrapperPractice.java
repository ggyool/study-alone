package org.wrapper.pack;

public class WrapperPractice {
	public static void main(String[] args) {
		int a = 10;
		// Wrapper Class
		// Integer, Boolean etc...
		Integer b = new Integer(20);
		Integer c = 30; // ���� �ڽ� - new ���� ������
		int d = b; // ���� ��ڽ� (������ intValue())
		
		System.out.println(a);
		System.out.println(b.intValue());
		System.out.println(b);
	}
}
