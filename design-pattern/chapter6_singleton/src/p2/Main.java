package p2;

import p2.Ticket.NormalTicket;
import p2.Ticket.NullTicket;
import p2.Ticket.Ticket;

public class Main {
    private static final int THREAD_NUM = 5;

    public static void main(String[] args) throws InterruptedException {
        User[] user = new User[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            user[i] = new User("user" + (i+1));
            user[i].start();
        }

        for (int i = 0; i < THREAD_NUM; i++) {
            user[i].join();     // Thread가 끝날 때 까지 기다림
            Ticket ticket = user[i].getTicket();
            if (ticket instanceof NullTicket) {
                System.out.println(user[i].getName() + " 티켓 없음.");
            } else {
                System.out.println(user[i].getName() + " 티켓 번호: " + ticket.getSerialNumber());
            }
        }
    }
}
