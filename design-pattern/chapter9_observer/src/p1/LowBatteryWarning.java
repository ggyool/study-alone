package p1;

import subject.Observer;

public class LowBatteryWarning implements Observer {
    private static final int LOW_BATTERY = 30;
    private final Battery battery;

    public LowBatteryWarning(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void update() {
        if (battery.getLevel() < LOW_BATTERY) {
            System.out.println("배터리 경고-> " + battery.getLevel() + "%");
        }
    }
}
