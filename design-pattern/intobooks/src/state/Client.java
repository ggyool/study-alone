package state;

public class Client {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(new NoCoin(), 0, 3);
        vendingMachine.insertCoin(3);
        vendingMachine.select();
        vendingMachine.select();
        vendingMachine.select();
        vendingMachine.select();
        vendingMachine.insertCoin(3);
    }
}
