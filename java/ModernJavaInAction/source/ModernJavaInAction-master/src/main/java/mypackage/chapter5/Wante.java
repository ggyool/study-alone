package mypackage.chapter5;

import java.util.Arrays;
import java.util.List;


public class Wante {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(1.0,2.0,3.0,4.0);
//plus
        System.out.println(doubles.stream().reduce(0.0, (a, b) -> (a+b)));
        System.out.println(doubles.parallelStream().reduce(0.0, (a, b) -> (a+b)));
        System.out.println(doubles.stream().reduce(0.0, (a, b) -> (a-b)));

        System.out.println(doubles.parallelStream().reduce(0.0, (a, b) -> (a-b)));
        System.out.println(doubles.parallelStream().reduce(0.0, (a, b) -> (a-b), (c, d) -> c + d));



        doubles.stream().reduce(1.0, (a, b) -> (a*b));
        doubles.parallelStream().reduce(1.0, (a, b) -> (a*b));
//divide
        doubles.stream().reduce(1.0, (a, b) -> (a/b));
        doubles.parallelStream().reduce(1.0, (a, b) -> (a/b));
    }
}

