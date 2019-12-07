package org.thread.practice;

public class JoinExam {
	public static void main(String[] args) {
		MyThread thread = new MyThread("abc");
		thread.start();
		System.out.println("main start");
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
