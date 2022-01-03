package state;

public interface MachineState {

    void insertCoin(VendingMachine vendingMachine, int coin);

    void select(VendingMachine vendingMachine);
}
