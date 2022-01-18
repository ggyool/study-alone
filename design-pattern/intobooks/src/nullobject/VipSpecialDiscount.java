package nullobject;

public class VipSpecialDiscount implements SpecialDiscount{
    @Override
    public void addDetailTo(Bill bill) {
        bill.addDiscount(new Item("VIP할인", 2000));
    }
}
