package mypackage.chapter5;

import java.util.Arrays;

public class Son {
    private static int[][] savings = new int[][]{
            {74, 80, 59, 68, 74, 80, 59, 68, 74, 80, 59, 68},
            {45, 34, 22, 54, 63, 22, 64, 34, 13, 34, 75, 33},
            {23, 34, 66, 64, 74, 43, 11, 56, 46, 34, 57, 43},
            {13, 44, 56, 7, 45, 45, 6, 45, 53, 66, 77, 5},
    };

    public static void main(String[] args) {
        final int NUMBER_OF_MONTH = 12;
        final int years = savings.length;


        final double money = Arrays.stream(savings)
                .flatMapToDouble(arr -> Arrays.stream(arr).asDoubleStream())
                .reduce(0.0, (sum, value) -> sum = 1.1 * sum + value);

        System.out.println(money); // 59183.5414287966


    }
}
