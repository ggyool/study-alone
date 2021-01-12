package p2;

public class LimpState extends CarState {
    public static final int LIMP_MODE_MAX_SPEED = 60;
    private static CarState instance;

    private LimpState(Car car) {
        super(car);
    }

    public static CarState getInstance(Car car) {
        if (instance == null) {
            instance = new LimpState(car);
        }
        return instance;
    }

    @Override
    protected void speedUp(int target) {
        int speed = car.getSpeed();
        if (target <= speed) {
            return;
        }
        car.setSpeed(Math.min(target, LIMP_MODE_MAX_SPEED));
        System.out.println(String.format("속도 증가: %d -> %d", speed, car.getSpeed()));
    }

    @Override
    protected void engineFailedDetected() {
        System.out.println("이미 림프모드");
    }

    @Override
    protected void engineRepaired() {
        System.out.println("노말 모드로 변경");
        car.setCurState(car.getNormalState());
    }
}
