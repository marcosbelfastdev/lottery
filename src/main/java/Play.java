import org.junit.Test;
import java.util.*;

public class Play {

    final int LOW = 0;
    final int HIGH = 59;
    final int NUMBER_OF_BALLS = 6;

    HashSet<Ticket> allMegasenaTickets = new HashSet<Ticket>();
    Random rnd = new Random();

    @Test
    public void playFixedSizeBallsPositive() {
        Ticket ticket = new Ticket(NUMBER_OF_BALLS, LOW, HIGH);
        ticket.add(1,2,3,4,5,6).play();
        System.out.println(ticket.toString());
    }

    @Test
    public void playExcedingBallsFixed() {
        /*
        Expected to cut off at number of balls (6)
         */
        Ticket ticket = new Ticket(NUMBER_OF_BALLS, LOW, HIGH);
        ticket.add(1,2,3,4,5,6,7).play();
        System.out.println(ticket.toString());
    }

    @Test
    public void playShortOfBalls() {
        /*
        Expected to complete with random balls
         */
        Ticket ticket = new Ticket(NUMBER_OF_BALLS, LOW, HIGH);
        ticket.add(1,2,3);
        ticket.play();
        System.out.println(ticket.toString());
    }

    @Test
    public void testGetAnyFrom1Ticket() {
        /*
        Expect to retrieve all unique balls
         */
//        Ticket ticket = new Ticket(NUMBER_OF_BALLS, LOW, HIGH);
//        ticket.add(1,2,3,4,5,6).play();
//        System.out.println(ticket.getAny(3, ticket));
    }

    @Test
    public void PlayMostFrequentRepeatPrevious() {

        final int MAX_TICKETS = 10;

        Ticket[] tickets = new Ticket[MAX_TICKETS];
        for (int i=0; i<MAX_TICKETS; i++) {
            tickets[i] = new Ticket(6, LOW, HIGH);
        }

        tickets[0].add(2, 6, 9, 45, 23, 7);
        tickets[0].play();
        for (int i=1; i<tickets.length; i++) {
            Ticket previous = tickets[i-1];
            //tickets[i].add(previous.getAny(2, previous).add(rnd(), 15, rnd());
            //tickets[i].play();
        }

//        ticket[0].addBalls(2, 45, random(), 26, random(), 23).applyRules(rules).play();
//        for (int i=1; i<ticket.length; i++) {
//            ticket[i].applyRules(rules);
//            ticket[i].getAny(2, ticket[i-1]).add().add(mf(0.20), mfp(), mfp()).play();
//        }
//
//        ticket[2].getAny(3, ticket[1]).add().add(2, 5, 7);
//        ticket[3].getAny(2, ticket[1]).add().getAny(4, ticket[2]).add().random().complete();
//        ticket[4].add(mf(), mfwp(), mfwp(10)).getAny(2, ticket[1],ticket[3]).add().random().complete();

    }

    public int rnd() {
        Random random = new Random();
        return random.nextInt(HIGH) + LOW;
    }
}
