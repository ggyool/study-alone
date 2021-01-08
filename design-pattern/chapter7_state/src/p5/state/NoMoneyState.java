package p5.state;

import p5.VendingMachine;

public class NoMoneyState implements State {
    private final VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pushBeverageButton() {
        throw new RuntimeException("충분한 돈이 없습니다.");
    }

    @Override
    public void pushReturnButton() {
        throw new RuntimeException("충분한 돈이 없습니다.");
    }
}
