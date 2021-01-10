package p2;

public class EscDecorator extends CarOptionDecorator {
    private final int escPrice;

    public EscDecorator(CarComponent decoratedCarComponent, int escPrice) {
        super(decoratedCarComponent);
        this.escPrice = escPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + escPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + " + esc";
    }
}
