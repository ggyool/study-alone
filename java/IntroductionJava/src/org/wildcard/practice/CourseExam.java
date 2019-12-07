package org.wildcard.practice;

public class CourseExam {
	public static void allOfType(Course<?> course)
	{
		System.out.println("allOfType");
	}
	public static void onlyInteger(Course<Integer> course)
	{
		System.out.println("onlyInteger");
	}
	public static void onlyString(Course<String> course)
	{
		System.out.println("onlyString");
	}
	public static void main(String[] args) {
		Course<Integer> cs = new Course<>("aaa", 5);
		cs.add(1);
		cs.add(2);
		cs.add(3);
		Course<String> cs2 = new Course<>("bbb", 5);
		cs2.add("a");
		cs2.add("b");
		cs2.add("c");
		onlyInteger(cs);
		onlyString(cs2);
	}
}
