import java.util.concurrent.Semaphore;

public class BankProblem {
    static class BankAcount{
        int balance;
        int depositCount = 0;
        int withdrawCount = 0;
        final int permit = 1;
        Semaphore sem;
        Semaphore orderSem;
        Semaphore depositSem, withdrawSem;
        BankAcount(){
            sem = new Semaphore(permit);
            orderSem = new Semaphore(0);
            depositSem = new Semaphore(0);
            withdrawSem = new Semaphore(0);
        }

        void deposit(int amount) {
            balance = balance + amount;
            ++depositCount;
            System.out.print("+");
            withdrawSem.release();
            try {
                depositSem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        void withdraw(int amount) {
            try {
                withdrawSem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = balance - amount;
            ++withdrawCount;
            System.out.print("-");
            depositSem.release();
        }
        int getBalance(){
            return this.balance;
        }
    }
    static class Parent extends Thread{
        BankAcount b;
        Parent(BankAcount b){
            this.b = b;
        }
        @Override
        public void run() {
            for(int i=0; i<100; ++i){
                for(int j=0; j<1000; ++j)
                    b.deposit(1);
            }
        }
    }

    static class Child extends Thread{
        BankAcount b;
        Child(BankAcount b){
            this.b = b;
        }
        @Override
        public void run() {
            for(int i=0; i<100; ++i){
                for(int j=0; j<1000; ++j)
                    b.withdraw(1);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        BankAcount b = new BankAcount();
        Parent p = new Parent(b);
        Child c = new Child(b);
        p.start();
        c.start();
        p.join();
        c.join();
        System.out.println();
        System.out.println("depositCount: " + b.depositCount);
        System.out.println("withdrawCount: " + b.withdrawCount);
        System.out.println("balance: " + b.getBalance());

    }
}
