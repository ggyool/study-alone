package mypackage.chapter6.reducetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReduceStreamTest {
    private static final Random RANDOM = new Random();
    public static List<Integer> numbers;
    public static void main(String[] args) {
        numbers = generateRandomNumbers(100_000_000, 10);
        final long start = System.nanoTime();
        final int result = numbers.stream()
                .reduce(0, (a, b) -> a - b);
        System.out.println("res:" + result);
        System.out.println(System.nanoTime() - start);
    }

    private static List<Integer> generateRandomNumbers(final int size, final int range) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(RANDOM.nextInt(range + 1) - range / 2);
        }
        return numbers;
    }
}
