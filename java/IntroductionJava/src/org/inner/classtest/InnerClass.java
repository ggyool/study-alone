package org.inner.classtest;

public class InnerClass {

	class Cal
	{
		int val = 0;
		public void plus()
		{
			val++;
		}
	}
	static class Cal2
	{
		int val = 0;
		public void plus()
		{
			val++;
		}
	}
	public static void main(String[] args)
	{
		InnerClass obj = new InnerClass();
		InnerClass.Cal cal = obj.new Cal();
		cal.plus();
		System.out.println(cal.val);
		
		InnerClass.Cal2 cal2 = new InnerClass.Cal2();
		cal2.plus();
		System.out.println(cal2.val);
	}
}
