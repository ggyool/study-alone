package p3.command;

import p3.ElevatorController;

public class DestinationSelectionCommand implements Command {
    private final ElevatorController elevatorController;
    private final int destination;

    public DestinationSelectionCommand(ElevatorController elevatorController, int destination) {
        this.elevatorController = elevatorController;
        this.destination = destination;
    }

    @Override
    public void execute() {
        elevatorController.gotoFloor(destination);
    }
}
