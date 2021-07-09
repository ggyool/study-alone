package mypackage.chapter4.distinctsoted;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctSortedTest {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        final long start = System.nanoTime();

        final List<Integer> collect = Stream.generate(() -> RANDOM.nextInt(10_000_001))
                .limit(9_000_000)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(System.nanoTime() - start);
    }
}
