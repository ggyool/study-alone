package p3.discount_strategy;

public class MemberDiscountStrategy implements DiscountStrategy {
    private static int MEMBER_DISCOUNT_RATE = 10;

    @Override
    public int getDiscountRate() {
        return MEMBER_DISCOUNT_RATE;
    }
}
