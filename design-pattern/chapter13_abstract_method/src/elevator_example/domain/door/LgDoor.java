package elevator_example.domain.door;

public class LgDoor extends Door {
    @Override
    protected void doOpen() {
        System.out.println("open lg door");
    }

    @Override
    protected void doClose() {
        System.out.println("close lg door");
    }
}
