package p3.discount_strategy;

public class DefaultDiscountStrategy implements DiscountStrategy {
    private static int DEFAULT_DISCOUNT_RATE = 0;

    @Override
    public int getDiscountRate() {
        return DEFAULT_DISCOUNT_RATE;
    }
}
