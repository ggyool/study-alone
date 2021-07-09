package mypackage.chapter6.reducetest;

import java.util.List;
import java.util.Random;

public class ReduceParallelStreamTest {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        final List<Integer> numbers = ReduceStreamTest.numbers;
        final long start = System.nanoTime();
        final int result = numbers.parallelStream()
                .reduce(0, (a, b) -> a - b, (a, b) -> a + b);
        System.out.println("res:" + result);
        System.out.println(System.nanoTime() - start);
    }
}
