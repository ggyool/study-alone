package org.thread.practice;

public class ThreadA {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();
		synchronized(b) {
			try {
				System.out.println("b start");
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("total: " + b.total);
		}
	}
}
