package modernjavainaction.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Gump {

    public static void main(String[] args) {
        Predicate<Integer> integerFilter = n -> (n == 0);
        final List<Integer> rawIntegers = Arrays.asList(1, 0, 3, 0, 5, 0, 7, 0, 9);
        int count = findZero(rawIntegers, integerFilter);
        System.out.println(count);
    }

    public static <T> Integer findZero(List<T> list, Predicate<T> predicate) {
        int count = 0;
        for (final T t : list) {
            if (predicate.test(t)) {
                ++count;
            }
        }
        return count;
    }
}
