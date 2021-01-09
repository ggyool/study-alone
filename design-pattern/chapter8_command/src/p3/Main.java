package p3;

import p3.command.DestinationSelectionCommand;
import p3.command.ElevatorRequestCommand;

public class Main {
    public static void main(String[] args) {
        Elevator elevator1 = new Elevator(1, 1);
        Elevator elevator2 = new Elevator(2, 1);

        ElevatorController elevatorController1 = new ElevatorController(elevator1);
        ElevatorController elevatorController2 = new ElevatorController(elevator2);

        ElevatorManager elevatorManager = new ElevatorManager();
        elevatorManager.addController(elevatorController1);
        elevatorManager.addController(elevatorController2);

        // 버튼1 - 1번 엘리베이터를 10층으로 이동시키는 버튼
        DestinationSelectionCommand destinationSelectionCommand1 = new DestinationSelectionCommand(elevatorController1, 10);
        ElevatorButton elevatorButton1 = new ElevatorButton(destinationSelectionCommand1);
        elevatorButton1.press();

        // 버튼2 - 2번 엘리베이터를 20층으로 이동시키는 버튼
        DestinationSelectionCommand destinationSelectionCommand2 = new DestinationSelectionCommand(elevatorController2, 20);
        ElevatorButton elevatorButton2 = new ElevatorButton(destinationSelectionCommand2);
        elevatorButton2.press();

        // 버튼3 - 5층에서 아래로 내려가는 버튼을 누른경우
        // 원래는 적절한 엘리베이터를 선택해야 하나 임시로 항상 첫번째 엘리베이터를 선택하게 되어 있음
        ElevatorRequestCommand elevatorRequestCommand = new ElevatorRequestCommand(elevatorManager, 5, Direction.DOWN);
        ElevatorButton elevatorButton3 = new ElevatorButton(elevatorRequestCommand);
        elevatorButton3.press();
    }
}
