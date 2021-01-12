package p2;

public class NormalState extends CarState {
    private static CarState instance;

    private NormalState(Car car) {
        super(car);
    }

    public static CarState getInstance(Car car) {
        if (instance == null) {
            instance = new NormalState(car);
        }
        return instance;
    }

    @Override
    protected void speedUp(int target) {
        int speed = car.getSpeed();
        if (target <= speed) {
            return;
        }
        car.setSpeed(target);
        System.out.println(String.format("속도 증가: %d -> %d", speed, target));
    }

    @Override
    protected void engineFailedDetected() {
        int speed = car.getSpeed();
        System.out.println("림프모드로 변경");
        car.setCurState(car.getLimpState());
        if (speed > LimpState.LIMP_MODE_MAX_SPEED) {
            car.setSpeed(LimpState.LIMP_MODE_MAX_SPEED);
            System.out.println(String.format("속도 감소: %d -> %d", speed, car.getSpeed()));
        }
    }

    @Override
    protected void engineRepaired() {
        System.out.println("이미 정상");
    }
}
