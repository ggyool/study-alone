package elevator_example.domain.door;

public class SamsungDoor extends Door {
    @Override
    protected void doOpen() {
        System.out.println("open samsung door");
    }

    @Override
    protected void doClose() {
        System.out.println("close samsung door");
    }
}
