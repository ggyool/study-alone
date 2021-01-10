package p2;

public class NaviDecorator extends CarOptionDecorator {
    private final int naviPrice;

    protected NaviDecorator(CarComponent decoratedCarComponent, int naviPrice) {
        super(decoratedCarComponent);
        this.naviPrice = naviPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + naviPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + " + navi";
    }
}
