package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class StatusSubject {
    private List<StatusObserver> observers = new ArrayList<>();

    public void add(StatusObserver statusObserver) {
        observers.add(statusObserver);
    }

    public void remove(StatusObserver statusObserver) {
        observers.remove(statusObserver);
    }

    public void notifyStatus(Status status) {
        for (StatusObserver observer : observers) {
            observer.onAbnormalStatus(status);
        }
    }
}
