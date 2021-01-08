package tests;
import org.junit.Test;

import components.Ticket;

import java.util.HashSet;
import java.util.Random;

public class MegasenaQuickTests {

    final int LOW = 0;
    final int HIGH = 59;
    int numberOfBalls = 6;

    HashSet<Ticket> allMegasenaTickets = new HashSet<Ticket>();
    Random rnd = new Random();

    @Test
    public void playFixedSizeBallsPositive() {
        Ticket ticket = new Ticket(numberOfBalls, LOW, HIGH);
        ticket.add(1,2,3,4,5,6).play();
        System.out.println(ticket.toString());
    }

    @Test
    public void playExceedingBallsFixed() {
        /*
        Expected to cut off at number of balls (6)
         */
        Ticket ticket = new Ticket(numberOfBalls, LOW, HIGH);
        ticket.add(1,2,3,4,5,6,7).play();
        System.out.println(ticket.toString());
    }

    @Test
    public void playShortOfBalls() {
        /*
        Expected to complete with random balls
         */
        Ticket ticket = new Ticket(numberOfBalls, LOW, HIGH);
        ticket.add(1,2,3);
        ticket.play();
        System.out.println(ticket.toString());
    }

    @Test
    public void testGetAny3From1Ticket() {
        /*
        Expect to retrieve all unique balls
         */
        Ticket ticket = new Ticket(numberOfBalls, LOW, HIGH);
        ticket.add(1,2,3,4,5,6).play();
        Ticket ticket2 = new Ticket(numberOfBalls, LOW, HIGH);
        ticket2.getAny(4, ticket);
        ticket2.play();
        System.out.println(ticket2);
    }

    public int rnd() {
        Random random = new Random();
        return random.nextInt(HIGH) + LOW;
    }
}
