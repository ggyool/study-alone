package p2;

public class Main {
    public static void main(String[] args) {
        ElevatorController elevatorController = new ElevatorController();
        elevatorController.attach(new ElevatorDisplay(elevatorController));
        elevatorController.attach(new VoiceNotice(elevatorController));
        elevatorController.attach(new FloorDisplay(elevatorController));
        elevatorController.attach(new ControlRoomDisplay(elevatorController));

        elevatorController.gotoFloor(5);
        elevatorController.gotoFloor(10);
    }
}
