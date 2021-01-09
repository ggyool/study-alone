package p3.command;

import p3.Direction;
import p3.ElevatorManager;

public class ElevatorRequestCommand implements Command {
    private final ElevatorManager elevatorManager;
    private final int floor;
    private final Direction direction;

    public ElevatorRequestCommand(ElevatorManager elevatorManager, int floor, Direction direction) {
        this.elevatorManager = elevatorManager;
        this.floor = floor;
        this.direction = direction;
    }

    @Override
    public void execute() {
        elevatorManager.requestElevator(floor, direction);
    }
}
