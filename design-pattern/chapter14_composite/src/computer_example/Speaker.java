package computer_example;

public class Speaker extends ComputerDevice {
    protected Speaker(int price, int power) {
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
