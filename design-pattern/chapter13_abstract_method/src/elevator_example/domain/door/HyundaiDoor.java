package elevator_example.domain.door;

public class HyundaiDoor extends Door {
    @Override
    protected void doOpen() {
        System.out.println("open hyundai door");
    }

    @Override
    protected void doClose() {
        System.out.println("close hyundai door");
    }
}
