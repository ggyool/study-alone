package mypackage.chapter6;

import java.util.Arrays;
import java.util.List;

public class MediumBear {
    public static void main(String[] args) {

        final List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0);

        final double sequentialMinus = numbers.stream()
                .reduce(0.0, (a, b) -> a - b);
        final double parallelMinus = numbers.parallelStream()
                .reduce(0.0, (a, b) -> a - b, (a, b) -> a + b);

        System.out.println(sequentialMinus + " / " + parallelMinus);

        final double sequentialDivide = numbers.stream()
                .reduce(1.0, (a, b) -> a / b);
        final double parallelDivide = numbers.parallelStream()
                .reduce(1.0, (a, b) -> a / b);
        /*
        순서 있는 병렬처리 Reduction
병렬처리에서 연산 순서에 따라 발생하는 문제를 해결하기 위해 다음과 같이 다른 규칙을 추가할 수 있습니다.
param으로 (total1, total2) -> total1 + total2를 추가하였는데 병렬처리된 결과의 관계를 나타냅니다.
첫번째 연산과 두번째 연산은 합해야 한다는 규칙을 정의하여, 연산결과가 순차처리와 동일하게 됩니다.

         */
        System.out.println(sequentialDivide + " / " + parallelDivide);

        /* 현재 실행 결과
            -10.0 / 0.0
            0.041666666666666664 / 1.5
         */

        /*  기대 결과
            -10.0 / -10.0
            0.041666666666666664 / 0.041666666666666664
         */


//        List<Integer> numbers = Arrays.asList(1, -2, 3, -4);
//        final Integer res =
//                numbers.parallelStream()
//                        .peek(System.out::println)
////                        .reduce(0, (sum, value) -> sum - value);
//                        .reduce(0, (sum, value) -> {
//                            System.out.println("acc: " + sum + " " + value);
//                            return sum - value;
//                        }, (a, b) -> {
//                            System.out.println("comb: " + a + " " + b);
//                            return a + b;
//                        });

//        System.out.println(numbers.stream().reduce(0, (a, b) -> a - b));

    }

}