package org.thread.practice;

public class ThreadB extends Thread{
	int total;
	public void run() {
		synchronized(this) {
			for(int i=0; i<5; ++i) {
				System.out.println(i+" plus");
				total += i;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			notify();
		}
	}
}
