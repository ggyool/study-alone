package p2;

import subject.Observer;

public class FloorDisplay implements Observer {
    private final ElevatorController elevatorController;

    public FloorDisplay(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }


    @Override
    public void update() {
        System.out.println("건물 내부: " + elevatorController.getFloor() + "층");
    }
}
