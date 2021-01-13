package elevator_example.domain.door;

import elevator_example.enum_type.DoorStatus;

public abstract class Door {
    private DoorStatus doorStatus;

    protected Door() {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    private void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public void open() {
        if (doorStatus == DoorStatus.OPENED) {
            return;
        }
        doOpen();
        setDoorStatus(DoorStatus.OPENED);
    }

    protected abstract void doOpen();

    public void close() {
        if (doorStatus == DoorStatus.CLOSED) {
            return;
        }
        doClose();
        setDoorStatus(DoorStatus.CLOSED);
    }

    protected abstract void doClose();
}
