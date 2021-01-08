package tests;

import org.junit.Test;
import java.util.*;
import components.Ticket;

public class MegaSena {

    final int LOW = 1;
    final int HIGH = 60;
    int numberOfBalls = 6;

    HashSet<Ticket> allMegasenaTickets = new HashSet<Ticket>();
    Random rnd = new Random();


    @Test
    public void PlayMostFrequentRepeatFromAll() {

        final int MAX_TICKETS = 20;

        Ticket[] tickets = new Ticket[MAX_TICKETS];
        for (int i=0; i<MAX_TICKETS; i++) {
            tickets[i] = new Ticket(6, LOW, HIGH);
        }

        tickets[0].add(rnd(), 27).play();                          // start with all random values
        for (int i=1; i<tickets.length; i++) {
            // now play by trying to get any 3 repeating balls amongst all played tickets
            tickets[i].getAny(2, tickets);
            tickets[i].add(rnd(), rnd(), 10);
            tickets[i].play();
        }

        for (int i=0; i<tickets.length; i++) {
            System.out.println(tickets[i].toString());
        }
    }

    @Test
    public void PlayMostFrequentRepeatPrevious() {

        final int MAX_TICKETS = 20;

        Ticket[] tickets = new Ticket[MAX_TICKETS];
        for (int i=0; i<MAX_TICKETS; i++) {
            tickets[i] = new Ticket(6, LOW, HIGH);
        }

        tickets[0].play();                          // start with all random values
        for (int i=1; i<tickets.length; i++) {
            // now play by trying to get any 3 repeating balls amongst all played tickets
            tickets[i].getAny(3, tickets[i-1]);
            tickets[i].play();
        }

        for (int i=0; i<tickets.length; i++) {
            System.out.println(tickets[i].toString());
        }
    }

    @Test
    public void allRandom() {

        final int MAX_TICKETS = 20;

        Ticket[] tickets = new Ticket[MAX_TICKETS];
        for (int i=0; i<MAX_TICKETS; i++) {
            tickets[i] = new Ticket(6, LOW, HIGH);
        }

        for (int i=0; i<tickets.length; i++) {
            // now play by trying to get any 3 repeating balls amongst all played tickets
            tickets[i].play();
        }

        for (int i=0; i<tickets.length; i++) {
            System.out.println(tickets[i].toString());
        }
    }

    public int rnd() {
        Random random = new Random();
        return random.nextInt(HIGH) + LOW;
    }
}
