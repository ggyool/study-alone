
public class BankAcount {
    int balance;
    synchronized void deposit(int amount){
        balance = balance + amount;
        System.out.print("+");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void withdraw(int amount){
        try {
            if(balance<=0)
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = balance - amount;
        System.out.print("-");
        notify();
    }
    int getBalance(){
        return balance;
    }
}

