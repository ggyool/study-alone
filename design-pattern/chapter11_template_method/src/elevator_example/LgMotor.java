package elevator_example;

public class LgMotor extends Motor {
    public LgMotor(Door door) {
        super(door);
    }

    @Override
    public void moveMotor(Direction direction) {
        System.out.println("엘지 모터 구동");
    }
}
