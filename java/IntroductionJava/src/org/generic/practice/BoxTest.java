package org.generic.practice;

public class BoxTest {
	public static void main(String[] args) {
		/*Box box = new Box();
		box.setObj(new Object());
		Object obj = box.getObj();
		
		box.setObj("hello"); // String�� Object�� ��ӹ޾ұ⿡ ����
		String str = (String)box.getObj();
		System.out.println(str);
		
		box.setObj(1);
		int val = (int)box.getObj();
		System.out.println(val);*/
		Box<Object> box = new Box<>();
		box.setObj(123);
		int a =  (int)box.getObj();
		System.out.println(a);
		
		Box<Integer> box2 = new Box<>();
		box2.setObj(123);
		int b = box2.getObj();
		System.out.println(b);
	}
}
