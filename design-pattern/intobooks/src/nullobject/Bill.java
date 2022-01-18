package nullobject;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items = new ArrayList<>();
    private List<Item> discounts = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void addDiscount(Item item) {
        discounts.add(item);
    }

    public int calculateItemPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int calculateFinalPrice() {
        int price = calculateItemPrice();
        for (Item discount : discounts) {
            price -= discount.getPrice();
        }
        return price;
    }
}
