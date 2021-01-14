package computer_example;

public class Monitor extends ComputerDevice {
    protected Monitor(int price, int power) {
        super(price, power);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getPower() {
        return power;
    }
}
