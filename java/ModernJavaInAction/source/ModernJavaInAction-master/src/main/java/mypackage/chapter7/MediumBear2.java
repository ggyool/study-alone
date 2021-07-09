package mypackage.chapter7;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MediumBear2 {
    public static void main(String[] args) {
        int n = 100_000_000;
        final List<Long> numbers = LongStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());
//                .collect(Collectors.toSet());
//                .collect(Collectors.toCollection(HashSet::new));

        long start = System.nanoTime();
        final Spliterator<Long> spliterator = numbers.spliterator();
        final Stream<Long> stream = StreamSupport.stream(spliterator, true);
        final long sum = stream.mapToLong(l -> l)
                .sum();

        System.out.println(System.nanoTime() - start);
        System.out.println(sum);
    }
}
