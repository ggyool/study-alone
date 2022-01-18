package nullobject;

public class SpecialDiscountFactory {
    public SpecialDiscount create(Customer customer) {
        if (customer.isFamilyCombination()) {
            return new HalfSpecialDiscount();
        }
        if (customer.isVip()) {
            return new VipSpecialDiscount();
        }
        return new NullSpecialDiscount();
    }
}
