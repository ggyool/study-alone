package nullobject;

public class Client {
    // 내가 정한 상황
    // 가족할인 50%
    // VIP 할인 2000원
    // 가족 할인 우선
    public static void main(String[] args) {
        SpecialDiscountFactory specialDiscountFactory = new SpecialDiscountFactory();

        // 가족할인 55000
        applyDiscount(specialDiscountFactory, createBill(), new Customer(false, true));

        // VIP 할인 108000
        applyDiscount(specialDiscountFactory, createBill(), new Customer(true, false));

        // 둘 다 대상이면 가족할인 우선 55000
        applyDiscount(specialDiscountFactory, createBill(), new Customer(true, true));

        // 적용할 할인 없음 110000
        applyDiscount(specialDiscountFactory, createBill(), new Customer(false, false));
    }

    private static Bill createBill() {
        Bill bill = new Bill();
        bill.addItem(new Item("기본사용요금", 100000));
        bill.addItem(new Item("할부금", 10000));
        return bill;
    }

    private static void applyDiscount(SpecialDiscountFactory specialDiscountFactory, Bill bill, Customer customer) {
        SpecialDiscount specialDiscount = specialDiscountFactory.create(customer);
        specialDiscount.addDetailTo(bill);
        System.out.println(bill.calculateFinalPrice());
    }
}
