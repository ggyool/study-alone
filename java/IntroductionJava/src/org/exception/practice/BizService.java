package org.exception.practice;

public class BizService {
	public void bizMethod(int i) throws BizException
	{
		System.out.println("bizMethod start");
		if(i<0) throw new BizException("i가 0보다 작습니다.");
		System.out.println("bizMethod end");
	}
}
