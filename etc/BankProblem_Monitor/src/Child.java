public class Child extends Thread{
    BankAcount b;
    Child(BankAcount b){
        this.b = b;
    }
    @Override
    public void run(){
        for(int i=0; i<1000; ++i){
            b.withdraw(1);
        }
    }
}
