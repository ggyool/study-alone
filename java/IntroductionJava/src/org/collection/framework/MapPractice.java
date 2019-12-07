package org.collection.framework;

import java.util.Iterator;
import java.util.TreeMap;

public class MapPractice {
	public static void main(String[] args) {
		TreeMap<Integer, String> hmp = new TreeMap<>();
		hmp.put(10, "1000");
		hmp.put(20, "200");
		hmp.put(30, "300");
		hmp.put(40, "400");
		hmp.put(40, "500");
		Iterator<Integer> iter = hmp.keySet().iterator();
		while(iter.hasNext())
		{
			System.out.println(hmp.get(iter.next()));
		}
		// same result
		for(Integer k:hmp.keySet())
		{
			System.out.println(hmp.get(k));
		}
		/*
		 *���� ��ġ�� ��ü���Ѵ�, �⺻������ key ���������ε�
		1000
		200
		300
		200
		 */
	}
}
