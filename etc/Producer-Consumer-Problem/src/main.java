public class main {
    public static void main(String[] args) {
        Buffer b = new Buffer(10);
        Producer p = new Producer(b, 1000000);
        Consumer c = new Consumer(b, 1000000);
        c.start();
        p.start();

        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Number of items: " + b.count);
    }
}
