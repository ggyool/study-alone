package p1;

import subject.Observer;

public class BatteryLevelDisplay implements Observer {
    private final Battery battery;

    public BatteryLevelDisplay(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void update() {
        System.out.print("----------------");
        System.out.print(battery.getLevel());
        System.out.print("%");
        System.out.println("----------------");
    }
}
