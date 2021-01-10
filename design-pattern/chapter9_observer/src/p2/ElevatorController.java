package p2;

import subject.Subject;

public class ElevatorController extends Subject {
    private int floor = 1;

    public void gotoFloor(int destination) {
        this.floor = destination;
        notifyObservers();
    }

    public int getFloor() {
        return floor;
    }
}
