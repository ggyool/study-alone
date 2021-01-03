package p3.discount_strategy;

public class BookDiscountStrategy implements DiscountStrategy {
    private static int BOOK_DISCOUNT_RATE = 10;

    @Override
    public int getDiscountRate() {
        return BOOK_DISCOUNT_RATE;
    }
}
