package elevator_example.factory;

import elevator_example.domain.door.Door;
import elevator_example.domain.door.LgDoor;
import elevator_example.domain.motor.HyundaiMotor;
import elevator_example.domain.motor.Motor;

public class HyundaiElevatorFactory extends ElevatorFactory {
    private static ElevatorFactory factory;

    private HyundaiElevatorFactory() {
    }

    public static ElevatorFactory getInstance() {
        if (factory == null) {
            factory = new HyundaiElevatorFactory();
        }
        return factory;
    }

    @Override
    public Motor createMotor() {
        return new HyundaiMotor();
    }

    @Override
    public Door createDoor() {
        return new LgDoor();
    }
}
