package state;

public class SoldOut implements MachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachine, int coin) {
        vendingMachine.returnCoin();
    }

    @Override
    public void select(VendingMachine vendingMachine) {
        System.out.println("품절");
    }
}
