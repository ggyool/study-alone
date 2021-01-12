package p1;

public abstract class Motor {
    private MotorStatus motorStatus;

    public Motor() {
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    private void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void move(Direction direction) {
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }

    public void stop() {
        this.motorStatus = MotorStatus.STOPPED;
    }

    protected abstract void moveMotor(Direction direction);
}
