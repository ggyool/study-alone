package p2;

import subject.Observer;

public class ElevatorDisplay implements Observer {
    private final ElevatorController elevatorController;

    public ElevatorDisplay(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void update() {
        System.out.println("엘리베이터 내부: " + elevatorController.getFloor() + "층");
    }
}
