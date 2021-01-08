package p5.state;

import p5.VendingMachine;

public class NotEnoughMoneyState implements State {
    private final VendingMachine vendingMachine;

    public NotEnoughMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pushBeverageButton() {
        throw new RuntimeException("충분한 돈이 없습니다.");
    }

    @Override
    public void pushReturnButton() {
        vendingMachine.returnMoney();
    }
}
