package elevator_example;

public class Main {
    public static void main(String[] args) {
        ElevatorManager em1 = new ElevatorManager(2, SchedulingStrategyId.THROUGHPUT);
        em1.requestElevator(10, Direction.UP);

        ElevatorManager em2 = new ElevatorManager(2, SchedulingStrategyId.RESPONSE_TIME);
        em2.requestElevator(10, Direction.UP);

        ElevatorManager em3 = new ElevatorManager(2, SchedulingStrategyId.DYNAMIC);
        em3.requestElevator(10, Direction.UP);
    }
}
