package mypackage.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExample {
    List<Cat> cats = new ArrayList<Cat>() {{
        add(new Cat("a", 10));
        add(new Cat("longName", 9));
        add(new Cat("bc", 17));
        add(new Cat("def", 12));
        add(new Cat("g", 13));
        add(new Cat("h", 3));
        add(new Cat("ijk", 14));
    }};

    public void printSuitedOne(BinaryOperator<Cat> operator) {
        cats.stream()
                .reduce(operator)
                .map(Cat::getName)
                .ifPresent(System.out::println);
    }


    public static void main(String[] args) {
        ReduceExample reduceExample = new ReduceExample();


        List<Integer> ages = Arrays.asList(10, 9, 17, 12, 13, 3, 14);
        ages.stream()
                .reduce(Math::max)
                .ifPresent(System.out::println);
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
