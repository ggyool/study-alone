package p5;

public class Stock {
    private static final int ZERO = 0;

    private final Beverage beverage;
    private int count = 0;

    public Stock(Beverage beverage, int count) {
        this.beverage = beverage;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getBeveragePrice() {
        return beverage.getPrice();
    }

    public String getBeverageName() {
        return beverage.getName();
    }

    public void reduceCount() {
        this.count--;
    }

    public boolean isSoldOut() {
        return this.count == ZERO;
    }
}
