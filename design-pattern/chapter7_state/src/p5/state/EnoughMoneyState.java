package p5.state;

import p5.VendingMachine;

public class EnoughMoneyState implements State {
    private final VendingMachine vendingMachine;

    public EnoughMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pushBeverageButton() {
        vendingMachine.takeOutBeverage();
    }

    @Override
    public void pushReturnButton() {
        vendingMachine.returnMoney();
    }
}
