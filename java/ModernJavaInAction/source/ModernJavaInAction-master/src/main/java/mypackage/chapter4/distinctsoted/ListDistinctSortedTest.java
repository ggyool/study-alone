package mypackage.chapter4.distinctsoted;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListDistinctSortedTest {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int size = 100_000_000;
        int range = 100_000;
        final List<Integer> numbers = generateRandomNumbers(size, range);

        final long start = System.nanoTime();

        final List<Integer> collect = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(System.nanoTime() - start);
    }

    private static List<Integer> generateRandomNumbers(final int size, final int range) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(RANDOM.nextInt(range + 1));
        }
        return numbers;
    }
}
