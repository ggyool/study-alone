package mypackage.chapter8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(10, 100);
        mp.put(20, 200);
        mp.put(30, 300);
        mp.entrySet();
    }
}
