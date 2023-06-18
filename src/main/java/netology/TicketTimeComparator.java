package netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flightTimeFirstTicket = t1.getTimeTo() - t1.getTimeFrom();
        int flightTimeSecondTicket = t2.getTimeTo() - t2.getTimeFrom();

        if (flightTimeFirstTicket < flightTimeSecondTicket) {
            return -1;
        } else if (flightTimeFirstTicket > flightTimeSecondTicket) {
            return 1;
        } else {
            return 0;
        }
    }
}
