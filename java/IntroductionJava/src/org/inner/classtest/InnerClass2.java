package org.inner.classtest;

public class InnerClass2 {
	public void exec()
	{
		class Cal
		{
			int val;
			public void plus() {++val;}
		}
		Cal cal = new Cal();
		cal.plus();
		System.out.println(cal.val);
	}
	public static void main(String[] args) {
		InnerClass2 obj = new InnerClass2();
		obj.exec();

	}

}
