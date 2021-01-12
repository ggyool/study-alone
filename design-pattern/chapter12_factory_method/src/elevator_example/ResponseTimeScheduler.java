package elevator_example;

public class ResponseTimeScheduler implements ElevatorScheduler {
    private ResponseTimeScheduler(){
    }

    private static class SingletonHolder {
        private static final ResponseTimeScheduler instance = new ResponseTimeScheduler();
    }

    public static ElevatorScheduler getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {
        return 1;
    }
}
