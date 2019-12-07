package org.thread.practice;

public class MyThreadExam2 {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("*");
		MyThread2 t2 = new MyThread2("-");
		// Runnable 객체는 t1.start() 할 수 없음
		// Thread 객체를 만들어서 사용해야함
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		thread1.start();
		thread2.start();
		// thread main,t1,t2 3개
		System.out.println("main end!!!");
	}
}
