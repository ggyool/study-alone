package p1;

public class ElevatorController {
    private final int id;
    private int floor = 1;
    private Motor motor;

    public ElevatorController(int id, Motor motor) {
        this.id = id;
        this.motor = motor;
    }

    public void gotoFloor(int destination) {
        if (floor == destination) {
            return;
        }

        Direction direction;
        if (destination > floor) {
            direction = Direction.UP;
        } else {
            direction = Direction.DOWN;
        }

        motor.move(direction);
        System.out.println(String.format("엘리베이터 id:%d / %d -> %d", id, floor, destination));
        this.floor = destination;
        motor.stop();
    }
}
