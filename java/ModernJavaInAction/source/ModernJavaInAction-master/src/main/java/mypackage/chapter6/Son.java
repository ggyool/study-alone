package mypackage.chapter6;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Son {
    static class Customer {
        private final String name;
        private final int[][] savingLogs;
        private final int age;

        public Customer(String name, int[][] savingLogs, int age) {
            this.name = name;
            this.savingLogs = savingLogs;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int[][] getSavingLogs() {
            return savingLogs;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    enum AgeRange {
        TEEN_TWENTY(n -> 10 <= n && n < 20),
        TWENTY_THIRD(n -> 20 <= n && n < 30),
        THIRD_FOURTH(n -> 30 <= n && n < 40);

        private final IntPredicate matchedFilter;

        AgeRange(final IntPredicate matchedFilter) {
            this.matchedFilter = matchedFilter;
        }

        public static AgeRange from(final int age) {
            return Arrays.stream(values())
                    .filter(ageRange -> ageRange.matchedFilter.test(age))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException());
        }
    }

    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("손너잘", new int[][]{
                        {74, 80, 1, 68, 74, 80, 59, 68, 74, 80, 59, 68},
                        {45, 34, 12, 54, 63, 2232, 64, 34, 13, 34, 75, 33},
                        {23, 34, 66, 624, 74, 43, 1231, 56, 46, 34, 57, 43},
                        {13, 44, 56, 74, 4235, 45, 6, 23445, 53, 66, 77, 5},
                }, 20),
                new Customer("손나잘", new int[][]{
                        {74, 830, 59, 68, 74, 80, 5239, 268, 74, 80, 59, 68},
                        {45, 34, 22, 54, 63, 2232, 64, 34, 13, 34, 75, 33},
                        {23, 34, 2366, 64, 74, 43, 13241, 56, 46, 34, 57, 43},
                        {13, 44, 5623, 723, 45, 45, 643, 54645, 53, 66, 77, 5},
                }, 24),
                new Customer("발너잘", new int[][]{
                        {74, 80, 59, 68, 74, 80, 59, 68, 74, 80, 59, 68},
                        {5, 4, 22, 54, 63, 2, 64, 34, 3, 34, 75, 33},
                        {23, 3, 6, 4, 74, 43, 11, 56, 6, 34, 7, 43},
                        {13, 44, 56, 3, 4, 4, 6, 45, 53, 66, 77, 5},
                }, 34),
                new Customer("발너못", new int[][]{
                        {74, 80, 59, 68, 74, 80, 59, 68, 74, 80, 59, 68},
                        {45, 3124, 22, 54, 63, 222, 64, 34, 13, 34, 75, 333},
                        {23, 3412, 66, 64, 74, 413, 121, 56, 46, 34, 57, 43},
                        {13, 44, 56, 7, 45, 45, 6, 45, 53, 66, 747, 25},
                }, 38),
                new Customer("손잘너", new int[][]{
                        {74, 80, 59, 684, 74, 80, 59, 68, 74, 80, 59, 648},
                        {45, 334, 22, 54, 63, 22, 64, 34, 13, 334, 75, 133},
                        {213, 34, 66, 64, 74, 43, 11, 561, 46, 34, 57, 43},
                        {113, 434, 546, 537, 45, 45, 6, 45, 53, 6136, 77, 5},
                }, 18),
                new Customer("손너못", new int[][]{
                        {74, 80, 59, 68, 74, 80, 59, 68, 74, 80, 59, 68},
                        {42345, 34, 2122, 54, 1363, 22, 64, 34, 13, 34, 75, 33},
                        {23, 34, 66, 634, 74, 43234, 11, 56, 46, 34, 57, 43435},
                        {13, 44, 23456, 7, 45, 45, 6, 45, 53, 66, 77, 345},
                }, 14),
                new Customer("발냄새", new int[][]{
                        {74, 80, 54329, 68, 74, 523480, 59, 68, 74, 23480, 59, 2348},
                        {45, 34, 22, 54, 63, 22342, 64, 34, 13, 34, 75, 32343},
                        {23, 34, 23466, 64, 74, 43, 23411, 56, 4634, 34, 57, 43},
                        {123453, 44, 56, 7234, 45, 45, 6, 45, 53, 66, 77, 5},
                }, 37)
        );

//        final Map<AgeRange, ? extends Number> collect = customers.stream()
//                .collect(
//                        groupingBy(
//                                customer -> AgeRange.from(customer.getAge()),
//                                mapping(
//                                        Customer::getSavingLogs,
//                                        flatMapping(
//                                                savings -> Arrays.stream(savings),
//                                                flatMapping(
//                                                        arr -> Arrays.stream(arr).boxed(),
//                                                        reducing(0.0, i -> i, (a, b) -> a.intValue() + b.intValue())
//                                                )
//                                        )
//                                )
//                        )
//                );

        final Map<AgeRange, List<IntSummaryStatistics>> collect = customers.stream()
                .collect(
                        groupingBy(
                                customer -> AgeRange.from(customer.getAge()),
                                mapping(
                                        Customer::getSavingLogs,
                                        mapping(savings -> Arrays.stream(savings).flatMapToInt(arr -> Arrays.stream(arr)).summaryStatistics(), toList()))
                        )
                );

//        System.out.println(collect);
    }


}
