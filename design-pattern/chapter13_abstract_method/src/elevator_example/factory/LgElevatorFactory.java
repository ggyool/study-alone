package elevator_example.factory;

import elevator_example.domain.door.Door;
import elevator_example.domain.door.LgDoor;
import elevator_example.domain.motor.LgMotor;
import elevator_example.domain.motor.Motor;

public class LgElevatorFactory extends ElevatorFactory {
    private static ElevatorFactory factory;

    private LgElevatorFactory() {
    }

    public static ElevatorFactory getInstance() {
        if (factory == null) {
            factory = new LgElevatorFactory();
        }
        return factory;
    }


    @Override
    public Motor createMotor() {
        return new LgMotor();
    }

    @Override
    public Door createDoor() {
        return new LgDoor();
    }
}
