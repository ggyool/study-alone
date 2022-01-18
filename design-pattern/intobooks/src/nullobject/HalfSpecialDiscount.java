package nullobject;

public class HalfSpecialDiscount implements SpecialDiscount {
    @Override
    public void addDetailTo(Bill bill) {
        int itemsPrice = bill.calculateItemPrice();
        int discountPrice = (int) (itemsPrice * 0.5);
        bill.addDiscount(new Item("반값할인", discountPrice));
    }
}
