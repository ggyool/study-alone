package p2;

public class CarStateFactory {
    public static CarState getState(CarStateId carStateId, Car car) {
        switch (carStateId) {
            case NORMAL:
                return NormalState.getInstance(car);
            case LIMP_MODE:
                return LimpState.getInstance(car);
            default:
                return null;
        }
    }
}
