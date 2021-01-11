package elevator_example;

public class HyundaiMotor extends Motor {
    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    public void moveMotor(Direction direction) {
        System.out.println("현대 모터 구동");
    }
}
