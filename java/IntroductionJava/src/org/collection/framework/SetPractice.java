package org.collection.framework;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetPractice {
	public static void main(String[] args) {
		TreeSet<Integer> tst = new TreeSet<>();
		tst.add(20);
		tst.add(10);
		tst.add(11);
		tst.add(12);
		tst.add(15);
		tst.add(16);
		tst.add(14);
		tst.add(13);
		// SortedSet return 받아야함
		SortedSet<Integer> pst = tst.subSet(10,15);
		Iterator<Integer> iter = pst.iterator();
		while(iter.hasNext())
		{
			// 10 11 12 13 14
			System.out.println(iter.next());
		}
	}
}
