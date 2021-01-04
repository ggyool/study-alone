package p2;

import p2.Ticket.Ticket;

public class User extends Thread {
    private Ticket ticket;

    public User(String name) {
        super(name);
    }

    public void run() {
        TicketManager ticketManager = TicketManager.getTicketManager();
        this.ticket = ticketManager.createTicket();
    }

    public synchronized Ticket getTicket() {
        return ticket;
    }
}
