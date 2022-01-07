package strategy;

import java.util.List;

public class Client {

    private DiscountStrategy discountStrategy;
    private List<Item> items;

    public void onFirstGuestButtonClick() {
        this.discountStrategy = new FirstGuestDiscountStrategy();
    }

    public void onNonFreshItemButtonClick() {
        this.discountStrategy = new NonFreshItemDiscountStrategy();
    }

    public void onCalculateButtonClick() {
        Calculator calculator = new Calculator(this.discountStrategy);
        int calculatedValue = calculator.calculate(items);
        System.out.println(calculatedValue);
    }
}
