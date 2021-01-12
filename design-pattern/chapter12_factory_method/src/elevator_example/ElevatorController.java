package elevator_example;

public class ElevatorController {
    private final int id;
    private int floor;

    public ElevatorController(int id) {
        this.id = id;
    }

    public void gotoFloor(int destination) {
        System.out.println(String.format("%d번 엘리베이터 %d층에서 %d층으로 이동", id, floor, destination));
        this.floor = destination;
    }
}
