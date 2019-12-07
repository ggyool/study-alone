package org.inner.classtest;

public class ActionTest {

	public static void main(String[] args) {
		// 일반적인 추상클래스 사용
		//Action action = new MyAction();
		//action.exec();
		Action action = new Action()
		{
			@Override
			public void exec()
			{
				System.out.println("exec");
			}
		};
		action.exec();
	}

}
