package mypackage.chapter7;

import java.util.HashSet;
import java.util.Set;
import java.util.Spliterator;

public class MediumBear {
    public static void main(String[] args) {
//        int n = 100_000_000;
//        List<Long> numbers = LongStream.rangeClosed(1, n)
//                .boxed()
//                .collect(Collectors.toList());
//
//        long start = System.nanoTime();
//        final long sum = numbers.stream()
//                .parallel()
//                .mapToLong(i -> i)
//                .sum();
        Set<Integer> st = new HashSet<>();
        final Spliterator<Integer> spliterator = st.spliterator();
//        System.out.println(System.nanoTime() - start);
//        System.out.println(sum);

    }
}
