package mystack;

import java.util.ArrayList;

public class MyStack{
	private ArrayList<String> list = new ArrayList<>();
	public void push(String e) {
		list.add(e);
	}
	public String top() {
		return list.get(list.size()-1);
	}
	public String pop() {
		return list.remove(list.size()-1);
	}
}
