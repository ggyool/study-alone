package p2;

public abstract class CarState {
    protected final Car car;

    protected CarState(Car car) {
        this.car = car;
    }

    public void speedDown(int target) {
        int speed = car.getSpeed();
        if (target >= speed) {
            return;
        }
        System.out.println(String.format("속도 감소: %d -> %d", speed, target));
        car.setSpeed(target);
    }

    protected abstract void speedUp(int target);

    protected abstract void engineFailedDetected();

    protected abstract void engineRepaired();
}
