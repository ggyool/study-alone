package org.one.pack;

public class AccessOne {
	public int publicOne;
	static protected int protectedOne;
	private int privateOne;
	public AccessOne()
	{
		this.publicOne = 1;
		this.protectedOne = 1;
		setPrivateOne(1);
	}
	private void setPrivateOne(int a)
	{
		this.privateOne = a;	
	}
	public int getPrivateOne()
	{
		return this.privateOne;
	}
}
