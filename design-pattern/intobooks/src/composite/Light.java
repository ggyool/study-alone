package composite;

public class Light implements Device{
    @Override
    public void turnOn() {
        System.out.println("Light on");
    }

    @Override
    public void turnOff() {
        System.out.println("Light off");
    }

    @Override
    public void addDevice(Device device) {
        throw new UnsupportedOperationException();
    }
}
