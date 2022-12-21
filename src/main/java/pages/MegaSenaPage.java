package pages;

import attributes.MegaSenaAttributes;
import components.Ticket;
import org.openqa.selenium.WebDriver;

import java.util.TreeSet;

public class MegaSenaPage extends MegaSenaAttributes {

    public MegaSenaPage(WebDriver driver) {
        super(driver);
    }

    public void apostarTudoAdicionarCarrinho(Ticket... tickets) {

        TreeSet<Integer> balls = new TreeSet<Integer>();
        for (Ticket ticket : tickets) {
            balls.addAll(ticket.getAllBallsPlayed());
            for (int ball : balls) {
                marcarNumero(ball);
            }
            colocarCarrinho().click();
            //driver().navigate().refresh();
            balls.clear();
        }
    }

    private void marcarNumero(int ball) {
        bola(ball).click();
    }

}
