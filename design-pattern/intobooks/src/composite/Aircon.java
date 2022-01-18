package composite;

public class Aircon implements Device {
    @Override
    public void turnOn() {
        System.out.println("Aircon on");
    }

    @Override
    public void turnOff() {
        System.out.println("Aircon off");
    }

    @Override
    public void addDevice(Device device) {
        throw new UnsupportedOperationException();
    }
}
