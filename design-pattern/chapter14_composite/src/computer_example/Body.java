package computer_example;

public class Body extends ComputerDevice {
    protected Body(int price, int power) {
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
