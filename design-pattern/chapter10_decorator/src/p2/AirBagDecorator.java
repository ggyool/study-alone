package p2;

public class AirBagDecorator extends CarOptionDecorator {
    private final int airbagPrice;

    protected AirBagDecorator(CarComponent decoratedCarComponent, int airbagPrice) {
        super(decoratedCarComponent);
        this.airbagPrice = airbagPrice;
    }


    @Override
    public int getPrice() {
        return super.getPrice() + airbagPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + " + airbag";
    }
}
