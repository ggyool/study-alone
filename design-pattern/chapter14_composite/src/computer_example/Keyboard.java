package computer_example;

public class Keyboard extends ComputerDevice {
    protected Keyboard(int price, int power) {
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
