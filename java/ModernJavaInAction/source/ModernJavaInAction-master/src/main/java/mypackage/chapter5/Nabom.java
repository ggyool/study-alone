package mypackage.chapter5;

import java.util.Random;
import java.util.stream.Collectors;

public class Nabom {
    public static void main(String[] args) {


//        final long start = System.nanoTime();
//        final Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            Stream.generate(() -> random.nextInt(45) + 1)
//                    .limit(50_000_000)
//                    .collect(Collectors.toList());
//        }
//        System.out.println(System.nanoTime() - start); // 1760206767 // 10054266323

        final long start = System.nanoTime();
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {
            random.ints(1, 46)
                    .limit(50_000_000)
                    .boxed()
                    .collect(Collectors.toList());
        }

        System.out.println(System.nanoTime() - start); // 1929741327 // 12630110852
//
//        final long start = System.nanoTime();;
//
//        Stream.generate(() -> new Random().nextInt(45) + 1)
//                .limit(50_000_000)
//                .collect(Collectors.toList());
//
//        System.out.println(System.nanoTime() - start); // 3542119065


    }
}