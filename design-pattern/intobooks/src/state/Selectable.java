package state;

public class Selectable implements MachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachine, int coin) {
        vendingMachine.increaseCoin(coin);
    }

    @Override
    public void select(VendingMachine vendingMachine) {
        vendingMachine.decreaseCoin();
        vendingMachine.provideProduct();

        if (vendingMachine.hasNoProduct()) {
            vendingMachine.changeState(new SoldOut());
        } else if (vendingMachine.hasNoCoin()) {
            vendingMachine.changeState(new NoCoin());
        }
    }
}
