package org.exception.practice;

public class BizService {
	public void bizMethod(int i) throws BizException
	{
		System.out.println("bizMethod start");
		if(i<0) throw new BizException("i�� 0���� �۽��ϴ�.");
		System.out.println("bizMethod end");
	}
}
