package composite;

import java.util.ArrayList;
import java.util.List;

public class DeviceGroup implements Device {

    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void turnOn() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

    public void turnOff() {
        for (Device device : devices) {
            device.turnOff();
        }
    }

}
