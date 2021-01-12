package elevator_example;

public class ThroughputScheduler implements ElevatorScheduler {
    private ThroughputScheduler(){
    }

    private static class SingletonHolder {
        private static final ThroughputScheduler instance = new ThroughputScheduler();
    }

    public static ElevatorScheduler getInstance() {
        return ThroughputScheduler.SingletonHolder.instance;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {
        return 0;
    }
}
