package a497_objects_test;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String s = new String("abc");
        String res = Objects.requireNonNull(s, "error");

        String ns = null;
//        String res2 = Objects.requireNonNull(ns, "error"); // NullPointException 발생

//        System.out.println(Objects.equals(null, null)); // true

        String[][] sarr1 = new String[][] {{"a"}, {"b"}};
        String[][] sarr2 = new String[][] {{"a"}, {"b"}};
        System.out.println(Objects.equals(sarr1, sarr2)); // false
        System.out.println(Objects.deepEquals(sarr1, sarr2)); // true
    }
}
