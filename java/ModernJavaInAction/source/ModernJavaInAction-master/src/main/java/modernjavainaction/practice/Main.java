package modernjavainaction.practice;

import java.util.function.BinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// 손너잘
public class Main {
    static private class MyNumber {
        private int num;
        public MyNumber(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }
        public void plusNum() {
            num++;
        }
        public MyNumber sum(MyNumber yourNumber) {
            return new MyNumber(num + yourNumber.num);
        }
    }
    public static void main(String[] args) {
        final long start = System.nanoTime();

//        UnaryOperator<Integer> unaryOperator1 = a -> {
        IntUnaryOperator unaryOperator1 = a -> {
            for (int i = 0; i < 100; i++) {
                a += 1;
            }
            return a;
        };

        UnaryOperator<MyNumber> unaryOperator2 = a -> {
            a.plusNum();
            return a;
        };
        BinaryOperator<MyNumber> binaryOperator = MyNumber::sum;
        Supplier<MyNumber> supplier1 = () -> new MyNumber(unaryOperator1.applyAsInt(3));
        Supplier<MyNumber> supplier2 = () -> new MyNumber(unaryOperator1.applyAsInt(5));
//        Supplier<MyNumber> supplier1 = () -> new MyNumber(unaryOperator1.apply(3));
//        Supplier<MyNumber> supplier2 = () -> new MyNumber(unaryOperator1.apply(5));
        MyNumber myNumber = new MyNumber(0);
//        Function<Integer, Integer> function1 = a -> a + 1;
        IntUnaryOperator function1 = a -> a + 1;
        for (int i = 0; i < 100; i++) {
//            myNumber = binaryOperator.apply(myNumber, binaryOperator.apply(supplier1.get(), supplier2.get()));
            myNumber = myNumber.sum(binaryOperator.apply(supplier1.get(), supplier2.get()));
        }
        for (int i = 0; i < 100; i++) {
            unaryOperator2.apply(myNumber);
        }
        int sum = 0;
        for(int i=0; i<100; i++) {
            sum += function1.applyAsInt(myNumber.getNum());
        }
        System.out.println(sum);

        System.out.println(System.nanoTime() - start);
    }
}