package p2;

import subject.Observer;

public class ControlRoomDisplay implements Observer {
    private final ElevatorController elevatorController;

    public ControlRoomDisplay(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void update() {
        System.out.println("중앙 통제실: " + elevatorController.getFloor() + "층");
    }
}
