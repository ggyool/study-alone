package mypackage.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Son {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 6, 2, 7, 4);
        Stream<Integer> stream = list.stream();
        Stream<Integer> sorted = stream.sorted();
        IntStream intStream = sorted.mapToInt(i -> {
            System.out.println(i);
            return i;
        });

        IntStream.rangeClosed(1, 10)
                .boxed()
                .sorted()
                .peek(i -> System.out.println(i));
//                .collect(Collectors.toList());
    }
}
