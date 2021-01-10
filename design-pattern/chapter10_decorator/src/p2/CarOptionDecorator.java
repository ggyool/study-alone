package p2;

public abstract class CarOptionDecorator extends CarComponent {
    private final CarComponent decoratedCarComponent;

    protected CarOptionDecorator(CarComponent decoratedCarComponent) {
        this.decoratedCarComponent = decoratedCarComponent;
    }

    @Override
    public int getPrice() {
        return decoratedCarComponent.getPrice();
    }

    @Override
    public String getCarInfo() {
        return decoratedCarComponent.getCarInfo();
    }
}
