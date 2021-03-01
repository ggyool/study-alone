package modernjavainaction.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

public class Practice {
    public static void main(String[] args) {
        final List<Integer> list = map(Arrays.asList("aaaaa", "bbb", "ccccccc"), s -> s.length());
        for (Integer integer : list) {
            System.out.println(integer);
        }
        final Function<String, Integer> function = String::length;
        final Function<String, Integer> stringIntegerIntegerBiFunction = Integer::parseInt;

        String s = "abc";
        ToIntFunction<String> stringToIntFunction = Integer::parseInt;
        BiPredicate<List<String>, String> biPredicate
                = List::contains;

    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> res = new ArrayList<>();
        for (T t : list) {
            res.add(function.apply(t));
        }
        return res;
    }
}