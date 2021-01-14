package computer_example;

public abstract class ComputerDevice {
    protected final int price;
    protected final int power;

    protected ComputerDevice(int price, int power) {
        this.price = price;
        this.power = power;
    }

    public abstract int getPrice();
    public abstract int getPower();
}
