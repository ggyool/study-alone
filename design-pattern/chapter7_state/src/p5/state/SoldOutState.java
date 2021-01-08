package p5.state;

import p5.VendingMachine;

public class SoldOutState implements State {
    private final VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pushBeverageButton() {
        throw new RuntimeException("음료 재고가 없습니다.");
    }

    @Override
    public void pushReturnButton() {
        throw new RuntimeException("음료 재고가 없습니다.");
    }
}
