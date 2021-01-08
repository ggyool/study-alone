package p5;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Beverage("콜라", 1000);
        Stock stock = new Stock(beverage, 3);

        VendingMachine vendingMachine = new VendingMachine(0, stock);
        vendingMachine.insertMoney(1000);
        vendingMachine.takeOutBeverage();
        vendingMachine.takeOutBeverage();


    }
}
