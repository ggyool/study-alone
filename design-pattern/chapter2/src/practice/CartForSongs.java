package practice;

import java.util.ArrayList;
import java.util.Iterator;

public class CartForSongs {
	ArrayList<Song> cart = new ArrayList<>();
	public double calcTotalPrice() {
		double total = 0.0d;
		Iterator<Song> iter = cart.iterator();
		while(iter.hasNext()) {
			Song s = iter.next();
			total = total + s.getPrice();
		}
		return total;
	}
	public void add(Song s) {
		cart.add(s);
	}
}
