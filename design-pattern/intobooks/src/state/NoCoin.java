package state;

public class NoCoin implements MachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachine, int coin) {
        vendingMachine.increaseCoin(coin);
        vendingMachine.changeState(new Selectable());
    }

    @Override
    public void select(VendingMachine vendingMachine) {
        System.out.println("코인 부족");
    }
}
