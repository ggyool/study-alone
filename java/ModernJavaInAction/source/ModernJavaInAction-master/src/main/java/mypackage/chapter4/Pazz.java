package mypackage.chapter4;

import java.util.Arrays;
import java.util.List;

public class Pazz {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        long count = list.stream()
                .peek(System.out::println)
                .count();
        System.out.println(count);
    }
}
