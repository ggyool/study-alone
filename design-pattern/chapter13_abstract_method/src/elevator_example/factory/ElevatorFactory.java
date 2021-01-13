package elevator_example.factory;

import elevator_example.domain.door.Door;
import elevator_example.domain.motor.Motor;

public abstract class ElevatorFactory {
    public abstract Motor createMotor();
    public abstract Door createDoor();
}
