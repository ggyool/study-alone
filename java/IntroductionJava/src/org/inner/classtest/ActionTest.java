package org.inner.classtest;

public class ActionTest {

	public static void main(String[] args) {
		// �Ϲ����� �߻�Ŭ���� ���
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
