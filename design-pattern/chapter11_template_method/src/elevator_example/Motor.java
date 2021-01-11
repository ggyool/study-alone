package elevator_example;

public abstract class Motor {
    private MotorStatus motorStatus;
    protected final Door door;

    protected Motor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus();
        DoorStatus doorStatus = door.getDoorStatus();
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }
        if (door.getDoorStatus() == DoorStatus.OPENED) {
            door.close();
        }
        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }

    public abstract void moveMotor(Direction direction);

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    protected void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }
}
