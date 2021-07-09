package mypackage.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 300_000_000).toArray();
        long start = System.nanoTime();

        final ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(numbers);
        System.out.println(forkJoinSumCalculator.invoke());
        System.out.println(System.nanoTime() - start);


        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        System.out.println(new ForkJoinPool().invoke(task));;
//        System.out.println(System.nanoTime() - start);

    }
}
