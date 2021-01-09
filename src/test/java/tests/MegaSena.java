package tests;

import attributes.LoteriasCaixaAttributes;
import org.junit.After;
import org.junit.Test;
import java.util.*;
import components.Ticket;
import org.openqa.selenium.WebDriver;
import pages.LoteriasCaixaPage;
import pages.MegaSenaPage;
import pages.PortalLoteriasPage;
import utils.DriverManager;

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
            tickets[i].getAny(3, tickets);
            tickets[i].play();
        }

        Apostas apostas = new Apostas();
        apostas.apostar(tickets);

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

        Apostas apostas = new Apostas();
        apostas.apostar(tickets);
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

    }

    public int rnd() {
        Random random = new Random();
        return random.nextInt(HIGH) + LOW;
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(600000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // gives you time to check out
        // webdriver will close automatically due to java hook.
    }
}
