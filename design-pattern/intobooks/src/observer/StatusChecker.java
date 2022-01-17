package observer;

public class StatusChecker extends StatusSubject {

    public void check() {
        Status status = loadStatus();

        if (status.isNotNormal()) {
            super.notifyStatus(status);
        }
    }

    private Status loadStatus() {
        return new Status();
    }
}
