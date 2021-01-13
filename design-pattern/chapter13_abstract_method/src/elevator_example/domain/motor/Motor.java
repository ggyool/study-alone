package elevator_example.domain.motor;

import elevator_example.domain.door.Door;
import elevator_example.enum_type.Direction;
import elevator_example.enum_type.DoorStatus;
import elevator_example.enum_type.MotorStatus;

public abstract class Motor {
    private MotorStatus motorStatus;
    private Door door;

    protected Motor() {
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    private void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void move(Direction direction) {
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }
        if (door.getDoorStatus() == DoorStatus.OPENED) {
            door.close();
        }
        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }

    protected abstract void moveMotor(Direction direction);
}
