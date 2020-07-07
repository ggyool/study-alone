import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

// (a) S1 이 끝나야 S2 나 S3 가 실행된다. S2, S3 의 순서는 상관없다.
// (b) S1 과 S2 가 모두 끝나야만 S3 가 실행된다. S1, S2 의 순서는 상관없다.
// (c) S1, S2, S3 의 순서대로 실행된다. 즉 S1 → S2 → S3 의 순서를 따라야 한다.

public class OrderingProblem {
    static Semaphore sem1 = new Semaphore(0);
    static Semaphore sem2 = new Semaphore(0);
    static Semaphore sem3 = new Semaphore(0);
    static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.print("1");
            sem2.release();
            try {
                sem1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                sem2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("2");
            sem3.release();
        }
    }
    static class Thread3 extends Thread{
        @Override
        public void run() {
            try {
                sem3.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("3");
            sem1.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for(int i=0; i<20; ++i) {
            List<Thread> list = new ArrayList<>();
            Thread1 t1 = new Thread1();
            Thread2 t2 = new Thread2();
            Thread3 t3 = new Thread3();
            list.add(t2);
            list.add(t3);
            list.add(t1);
            Collections.shuffle(list);
            for (Thread thread : list) {
                thread.start();
            }
            t1.join();
            t2.join();
            t3.join();
            System.out.println();
        }
    }
}
