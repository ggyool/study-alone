package p2.Ticket;

public class NormalTicket implements Ticket {
    private final int serialNumber;

    public NormalTicket(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }
}
