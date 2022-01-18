package composite;

public class Client {
    public static void main(String[] args) {
        Device airconGroup = new DeviceGroup();
        airconGroup.addDevice(new Aircon());
        airconGroup.addDevice(new Aircon());
        airconGroup.addDevice(new Aircon());

        Device lightGroup = new DeviceGroup();
        lightGroup.addDevice(new Light());
        lightGroup.addDevice(new Light());
        lightGroup.addDevice(new Light());

        Device deviceGroup = new DeviceGroup();
        deviceGroup.addDevice(airconGroup);
        deviceGroup.addDevice(lightGroup);
        deviceGroup.turnOn();
        deviceGroup.turnOff();
    }
}
