package mypackage.chapter4;

import java.util.Arrays;
import java.util.List;

public class Nabom {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2);
        integers.stream()
                .peek(i -> System.out.println("peek : " + i))
                .forEach(i -> System.out.println("foreach : "+ i));
    }
}
