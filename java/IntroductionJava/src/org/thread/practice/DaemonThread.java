package org.thread.practice;

public class DaemonThread implements Runnable{
	@Override
	public void run() {
		while(true)
		{
			System.out.println("daemon run");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				// sleep �ϴ� ���� Exception�� �߻��ߴٸ� �����������Ѵ�.
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonThread());
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
