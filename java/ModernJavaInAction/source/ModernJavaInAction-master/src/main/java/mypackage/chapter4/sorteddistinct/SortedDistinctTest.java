package mypackage.chapter4.sorteddistinct;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedDistinctTest {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        final long start = System.nanoTime();

        final List<Integer> collect = Stream.generate(() -> RANDOM.nextInt(100_000))
                .limit(1_000_000_000)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(System.nanoTime() - start);
    }
}
