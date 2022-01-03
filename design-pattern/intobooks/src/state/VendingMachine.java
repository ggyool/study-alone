package state;

public class VendingMachine {

    private MachineState machineState;
    private int coin;
    private int products;

    public VendingMachine(MachineState machineState, int coin, int products) {
        this.machineState = machineState;
        this.coin = coin;
        this.products = products;
    }

    public void changeState(MachineState machineState) {
        this.machineState = machineState;
    }

    public void insertCoin(int coin) {
        machineState.insertCoin(this, coin);
    }

    public void select() {
        machineState.select(this);
    }

    public void increaseCoin(int coin) {
        this.coin += coin;
        System.out.println("코인 투입, 잔액: " + this.coin);
    }

    public void provideProduct() {
        this.products -= 1;
        System.out.println("상품 제공, 남은 상품: " + this.products);
    }

    public void decreaseCoin() {
        this.coin -= 1;
    }

    public boolean hasNoProduct() {
        return this.products == 0;
    }

    public boolean hasNoCoin() {
        return this.coin == 0;
    }

    public void returnCoin() {
        System.out.println("코인 반환: " + this.coin);
        this.coin = 0;
    }
}
