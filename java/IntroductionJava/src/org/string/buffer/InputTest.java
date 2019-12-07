package org.string.buffer;

public class InputTest {
	public static void main(String[] args) {
		long startTime, endTime;
		// ���ڿ��� ��� �ٿ����� ���
		startTime = System.currentTimeMillis();
		String s1 = "";
		for(int i=0; i<100000; ++i) {
			s1 = s1 + '*';
		}
		//System.out.println(s1);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// �� �ǵ����� ���� �Ʒ��� ����
		startTime = System.currentTimeMillis();
		String s2 = "";
		for(int i=0; i<100000; ++i)
		{
			s2 = new StringBuffer(s2).append('*').toString();
		}
		//System.out.println(s2);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// �Ʒ� ó�� �ϴ°� ����.
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
