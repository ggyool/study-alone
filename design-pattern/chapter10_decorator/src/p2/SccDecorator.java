package p2;

public class SccDecorator extends CarOptionDecorator {
    private final int sccPrice;

    public SccDecorator(CarComponent decoratedCarComponent, int sccPrice) {
        super(decoratedCarComponent);
        this.sccPrice = sccPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + sccPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + " + scc";
    }
}
