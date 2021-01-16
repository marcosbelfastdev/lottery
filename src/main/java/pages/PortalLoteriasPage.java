package pages;

import attributes.PortalLoteriasAttributes;

import static utils.DriverManager.driver;

public class PortalLoteriasPage extends PortalLoteriasAttributes {

    public void apostar() {
        cliqueAposte().click();
        driver().load("https://www.loteriasonline.caixa.gov.br/silce-web/#/home?utm_source=siteLoterias&utm_medium=bannercrossLoterias&utm_campaign=loteriasonline&utm_content=aposteja");
    }

}
