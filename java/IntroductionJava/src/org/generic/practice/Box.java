package org.generic.practice;

// c++템플릿이랑 비슷한 제너릭
// E 가상클래스s
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
