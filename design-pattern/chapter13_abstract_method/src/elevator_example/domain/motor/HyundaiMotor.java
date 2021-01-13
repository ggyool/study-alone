package elevator_example.domain.motor;

import elevator_example.enum_type.Direction;

public class HyundaiMotor extends Motor {
    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("move hyundai motor");
    }
}
