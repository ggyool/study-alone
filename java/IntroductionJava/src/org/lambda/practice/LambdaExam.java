package org.lambda.practice;

public class LambdaExam {
	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0; i<5;++i)
				System.out.println("hello");
		}).start();
	}
}
