package components;

import java.util.ArrayList;
import java.util.List;

public class TicketSeries {

    List<Ticket> _tickets;

    public TicketSeries(int seriesSize, int numberOfBalls, int low, int high) {
        _tickets = new ArrayList<Ticket>();
        for (int i=0; i<seriesSize; i++) {
            Ticket ticket = new Ticket(numberOfBalls, low, high);
            _tickets.add(ticket);
        }
    }

    public Ticket getTicket(int position) {
        return _tickets.get(position);
    }

    public void deduplicate() {
        /*
        Removes duplicate tickets (same balls played)
         */
        List<Integer> hashCodes = new ArrayList<Integer>();
        for (Ticket ticket : _tickets) {
            if (hashCodes.contains(ticket.hashCode())) {
                // a duplicate ticket is found
                _tickets.remove(ticket);
                System.out.println("A duplicate ticket has been removed.");
            }
            hashCodes.add(ticket.hashCode());
        }
    }

    public Ticket[] getTickets() {
        return (Ticket[]) _tickets.toArray();
    }

    public int size() {
        return _tickets.size();
    }

}
