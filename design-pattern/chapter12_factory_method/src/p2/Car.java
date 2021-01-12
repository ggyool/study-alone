package p2;

public class Car {
    private int speed = 0;
    private CarState curState;
    private CarState limpState;
    private CarState normalState;

    public Car() {
        limpState = CarStateFactory.getState(CarStateId.LIMP_MODE, this);
        normalState = CarStateFactory.getState(CarStateId.NORMAL, this);
        curState = normalState;
    }

    public void speedUp(int target) {
        curState.speedUp(target);
    }

    public void speedDown(int target) {
        curState.speedDown(target);
    }

    public void enginedFailedDetected() {
        curState.engineFailedDetected();
    }

    public void engineRepaired() {
        curState.engineRepaired();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCurState(CarState curState) {
        this.curState = curState;
    }

    public CarState getNormalState() {
        return normalState;
    }

    public CarState getLimpState() {
        return limpState;
    }
}
