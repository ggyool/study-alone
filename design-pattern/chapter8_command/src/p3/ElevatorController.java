package p3;

public class ElevatorController {
    private final Elevator elevator;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public void gotoFloor(int destination) {
        elevator.moveFloor(destination);
    }
}
