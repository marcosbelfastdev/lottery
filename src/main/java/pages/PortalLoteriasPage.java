package pages;

import attributes.PortalLoteriasAttributes;
import org.openqa.selenium.WebDriver;

public class PortalLoteriasPage extends PortalLoteriasAttributes {

    public PortalLoteriasPage(WebDriver driver) {
        super(driver);
    }

    public void apostar() {
        cliqueAposte().click();
        this.driver.get("https://www.loteriasonline.caixa.gov.br/silce-web/#/home?utm_source=siteLoterias&utm_medium=bannercrossLoterias&utm_campaign=loteriasonline&utm_content=aposteja");
    }

}
