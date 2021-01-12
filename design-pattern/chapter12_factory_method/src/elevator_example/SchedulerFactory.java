package elevator_example;

import java.util.Calendar;

public class SchedulerFactory {
    public static ElevatorScheduler getScheduler(SchedulingStrategyId schedulingStrategyId) {
        final int DAYTIME = 12;
        switch (schedulingStrategyId) {
            case RESPONSE_TIME:
                return ResponseTimeScheduler.getInstance();
            case THROUGHPUT:
                return ThroughputScheduler.getInstance();
            case DYNAMIC:
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if (hour < DAYTIME)
                    return ResponseTimeScheduler.getInstance();
                else
                    return ThroughputScheduler.getInstance();
            default:
                return null;
        }
    }
}
