package org.generic.practice;

// c++���ø��̶� ����� ���ʸ�
// E ����Ŭ����s
public class Box<E> {
	private E obj;
	public void setObj(E obj)
	{
		this.obj = obj;
	}
	public E getObj()
	{
		return obj;
	}
}
