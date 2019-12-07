package org.collection.framework;

import java.util.ArrayList;

public class ListPractice {
	public static void main(String[] args) {
		ArrayList<Integer> lst = new ArrayList<>();
		lst.add(10);
		lst.add(20);
		lst.add(30);
		for(int i=0; i<lst.size(); ++i)
		{
			System.out.println(lst.get(i));
		}
	}
}
