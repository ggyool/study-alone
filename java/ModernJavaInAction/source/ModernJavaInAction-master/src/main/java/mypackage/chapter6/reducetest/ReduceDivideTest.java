package mypackage.chapter6.reducetest;

import java.util.Arrays;
import java.util.List;

public class ReduceDivideTest {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(1.0,2.0,3.0,4.0);

        System.out.println(doubles.stream().reduce(1.0, (a, b) -> (a/b)));
        System.out.println(doubles.parallelStream().reduce(1.0, (a, b) -> (a/b), (a,b) ->a*b));

    }
}
