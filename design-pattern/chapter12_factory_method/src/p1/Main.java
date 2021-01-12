package p1;

public class Main {
    public static void main(String[] args) {
        Motor lgMotor = MotorFactory.getMotor(MotorVendorId.LG);
        ElevatorController elevatorController1 = new ElevatorController(1, lgMotor);
        elevatorController1.gotoFloor(5);
        elevatorController1.gotoFloor(3);

        Motor hyundaiMotor = MotorFactory.getMotor(MotorVendorId.HYUNDAI);
        ElevatorController elevatorController2 = new ElevatorController(2, hyundaiMotor);
        elevatorController2.gotoFloor(4);
        elevatorController2.gotoFloor(6);
    }
}
