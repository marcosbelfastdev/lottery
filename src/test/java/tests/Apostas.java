package tests;

import components.Ticket;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pages.LoteriasCaixaPage;
import pages.MegaSenaPage;
import pages.PortalLoteriasPage;
import utils.DriverManager;

public class Apostas {

    WebDriver browser;

    public void apostar(Ticket... tickets) {

        browser = new DriverManager().launchBrowser();
        //driver().setOption(Common.HIGHLIGHT_ELEMENTS, true);
        browser.navigate().to("http://loterias.caixa.gov.br/wps/portal/loterias");

        PortalLoteriasPage portal = new PortalLoteriasPage(browser);
        portal.apostar();

        LoteriasCaixaPage loterias = new LoteriasCaixaPage(browser);
        loterias.confirmarIdade();
        loterias.apostar();

        MegaSenaPage megaSena = new MegaSenaPage(browser);
        megaSena.apostarTudoAdicionarCarrinho(tickets);
    }

}
