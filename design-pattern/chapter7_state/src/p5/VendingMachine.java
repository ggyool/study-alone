package p5;

import p5.state.EnoughMoneyState;
import p5.state.NoMoneyState;
import p5.state.NotEnoughMoneyState;
import p5.state.SoldOutState;
import p5.state.State;

public class VendingMachine {
    private static final int ZERO = 0;

    private int money;
    private final Stock stock;
    private State state;
    private final NoMoneyState noMoneyState;
    private final EnoughMoneyState enoughMoneyState;
    private final NotEnoughMoneyState notEnoughMoneyState;
    private final SoldOutState soldOutState;


    public VendingMachine(int money, Stock stock) {
        this.money = money;
        this.stock = stock;

        this.noMoneyState = new NoMoneyState(this);
        this.enoughMoneyState = new EnoughMoneyState(this);
        this.notEnoughMoneyState = new NotEnoughMoneyState(this);
        this.soldOutState = new SoldOutState(this);
        this.state = this.noMoneyState;
    }

    public void insertMoney(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException("돈은 양수만 될 수 있습니다.");
        }
        this.money += money;
        printMoney();
        decideState();
    }

    public void returnMoney() {
        System.out.println("돈을 반환합니다: " + money + "원");
        money = 0;
        decideState();
    }

    private void decideState() {
        if (isSoldOutState()) {
            this.state = this.soldOutState;
            return;
        }
        decideMoneyState();
    }

    private boolean isSoldOutState() {
        int count = stock.getCount();
        return count == ZERO;
    }

    public void takeOutBeverage() {
        System.out.println(stock.getBeverageName() + "를 뽑았습니다.");
        this.money -= stock.getBeveragePrice();
        stock.reduceCount();
        decideState();
    }

    private void decideMoneyState() {
        int beveragePrice = stock.getBeveragePrice();
        if (money == ZERO) {
            this.state = this.noMoneyState;
            return;
        }
        if (money >= beveragePrice) {
            this.state = this.enoughMoneyState;
            return;
        }
        this.state = this.notEnoughMoneyState;
    }

    public void printMoney() {
        System.out.println("잔액: " + money);
    }
}
