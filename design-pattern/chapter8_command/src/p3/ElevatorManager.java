package p3;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private static final int FIRST = 0;
    private List<ElevatorController> controllers = new ArrayList<>();

    public void addController(ElevatorController elevatorController) {
        controllers.add(elevatorController);
    }

    public void requestElevator(int floor, Direction direction) {
        ElevatorController elevatorController = selectController(floor, direction);
        elevatorController.gotoFloor(floor);
    }

    // 적절한 엘리베이터를 선택해야 하나 임시로 첫번째 엘리베이터만 선택하게 해 놓음
    private ElevatorController selectController(int destination, Direction direction) {
        return controllers.get(FIRST);
    }
}
