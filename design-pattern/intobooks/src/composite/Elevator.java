package composite;

public class Elevator implements Device {
    @Override
    public void turnOn() {
        System.out.println("Elevator on");
    }

    @Override
    public void turnOff() {
        System.out.println("Elevator off");
    }

    @Override
    public void addDevice(Device device) {
        throw new UnsupportedOperationException();
    }
}
