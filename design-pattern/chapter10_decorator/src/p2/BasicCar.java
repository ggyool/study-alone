package p2;

public class BasicCar extends CarComponent {
    private final int price;

    public BasicCar(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getCarInfo() {
        return "Car";
    }
}
