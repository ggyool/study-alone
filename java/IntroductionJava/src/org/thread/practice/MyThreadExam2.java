package org.thread.practice;

public class MyThreadExam2 {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("*");
		MyThread2 t2 = new MyThread2("-");
		// Runnable ��ü�� t1.start() �� �� ����
		// Thread ��ü�� ���� ����ؾ���
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		thread1.start();
		thread2.start();
		// thread main,t1,t2 3��
		System.out.println("main end!!!");
	}
}
