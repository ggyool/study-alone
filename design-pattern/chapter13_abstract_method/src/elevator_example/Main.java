package elevator_example;

import elevator_example.domain.door.Door;
import elevator_example.domain.motor.Motor;
import elevator_example.enum_type.Direction;
import elevator_example.enum_type.VendorId;
import elevator_example.factory.ElevatorFactory;
import elevator_example.factory.ElevatorFactoryFactory;

public class Main {
    public static void main(String[] args) {
        ElevatorFactory lgElevatorFactory = ElevatorFactoryFactory.getElevatorFactory(VendorId.LG);

        Door door = lgElevatorFactory.createDoor();
        Motor motor = lgElevatorFactory.createMotor();
        motor.setDoor(door);

        door.open();
        motor.move(Direction.UP);


    }
}
