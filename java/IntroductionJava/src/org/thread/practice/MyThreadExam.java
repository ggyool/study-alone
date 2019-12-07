package org.thread.practice;

public class MyThreadExam {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("*");
		MyThread t2 = new MyThread("-");
		t1.start();
		t2.start();
		// thread main,t1,t2 3°³
		System.out.println("main end!!!");
	}
}
