package tests;

import components.Ticket;
import org.base.erbium.Common;
import org.base.erbium.EDriver;
import org.junit.BeforeClass;
import pages.LoteriasCaixaPage;
import pages.MegaSenaPage;
import pages.PortalLoteriasPage;
import utils.DriverManager;

import static utils.DriverManager.driver;

public class Apostas {

    EDriver browser;

    public void apostar(Ticket... tickets) {

        DriverManager.launchBrowser();
        driver().setOption(Common.HIGHLIGHT_ELEMENTS, true);
        driver().navigate().to("http://loterias.caixa.gov.br/wps/portal/loterias");

        PortalLoteriasPage portal = new PortalLoteriasPage();
        portal.apostar();

        LoteriasCaixaPage loterias = new LoteriasCaixaPage();
        loterias.confirmarIdade();
        loterias.apostar();

        MegaSenaPage megaSena = new MegaSenaPage();
        megaSena.apostarTudoAdicionarCarrinho(tickets);
    }

}
