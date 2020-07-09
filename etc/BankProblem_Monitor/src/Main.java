public class Main {
    public static void main(String[] args) {
        BankAcount b = new BankAcount();
        Parent p = new Parent(b);
        Child c = new Child(b);

        p.start();
        c.start();

        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(b.getBalance());
    }
}
