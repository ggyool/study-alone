package p2;

import p2.Ticket.NormalTicket;
import p2.Ticket.NullTicket;
import p2.Ticket.Ticket;

public class TicketManager {
    private final int MAX_TICKET_COUNT = 3;
    private static TicketManager ticketManager = null;
    private int ticketCount = 0;

    private TicketManager() {
    }

    public synchronized static TicketManager getTicketManager() {
        if (ticketManager == null) {
            ticketManager = new TicketManager();
        }
        return ticketManager;
    }

    public synchronized Ticket createTicket() {
        if (ticketCount >= MAX_TICKET_COUNT) {
            return new NullTicket();
        }
        return new NormalTicket(++ticketCount);
    }
}
