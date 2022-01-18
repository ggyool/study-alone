package composite;

public interface Device {
    void turnOn();

    void turnOff();

    // 컴포지트를 위한 메서드
    void addDevice(Device device);
}
