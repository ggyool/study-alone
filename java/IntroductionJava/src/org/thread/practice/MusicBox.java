package org.thread.practice;

public class MusicBox {
	public synchronized void playMusicA() {
		for(int i=0; i<10; ++i) {
			System.out.println("A music" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized void playMusicB() {
		for(int i=0; i<10; ++i) {
			System.out.println("B music"+ i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void playMusicC() {
		for(int i=0; i<10; ++i) {
			synchronized(this){
				System.out.println("C music"+ i);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
