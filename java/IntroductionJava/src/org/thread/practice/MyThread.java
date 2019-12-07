package org.thread.practice;

public class MyThread extends Thread{
	String str;
	public MyThread(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		System.out.println("thred run");
		/*for(int i=0; i<5; ++i) {
			System.out.println(str);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
}
