package elevator_example;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private final List<ElevatorController> elevatorControllers;
    private SchedulingStrategyId strategyId;

    public ElevatorManager(int controllerCount, SchedulingStrategyId strategyId) {
        elevatorControllers = new ArrayList<>();
        for (int i = 0; i < controllerCount; i++) {
            elevatorControllers.add(new ElevatorController(i + 1));
        }
        this.strategyId = strategyId;
    }

    public void setStrategyId(SchedulingStrategyId strategyId) {
        this.strategyId = strategyId;
    }

    void requestElevator(int destination, Direction direction) {
        ElevatorScheduler elevatorScheduler = SchedulerFactory.getScheduler(strategyId);
        System.out.println(elevatorScheduler);
        int selectedElevatorIndex = elevatorScheduler.selectElevator(this, destination, direction);
        elevatorControllers.get(selectedElevatorIndex)
                .gotoFloor(destination);
    }
}
