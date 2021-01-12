package p1;

public class MotorFactory {
    public static Motor getMotor(MotorVendorId motorVendorId) {
        switch (motorVendorId) {
            case LG:
                return new LgMotor();
            case HYUNDAI:
                return new HyundaiMotor();
            default:
                return null;
        }
    }
}
