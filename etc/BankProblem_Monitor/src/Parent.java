public class Parent extends Thread{
    BankAcount b;
    Parent(BankAcount b){
        this.b = b;
    }
    @Override
    public void run(){
        for(int i=0; i<1000; ++i){
            b.deposit(1);
        }
    }
}
