package mypackage.chapter5;

import java.util.stream.Stream;

public class MediumBear {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 1)
                .skip(5) // 0~4 skip
                .limit(10) // 5~14
                .filter( n -> n % 2 == 0) // 6 8 10 12 14 ...
                .skip(1) // 6 skip
                .limit(3) // 8 10 12
                .skip(1) // 8 skip
                .forEach(System.out::println); // 10 12
    }
}
