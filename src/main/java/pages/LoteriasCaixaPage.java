package pages;

import attributes.LoteriasCaixaAttributes;
import attributes.PortalLoteriasAttributes;
import org.openqa.selenium.WebDriver;

public class LoteriasCaixaPage extends LoteriasCaixaAttributes {

    public LoteriasCaixaPage(WebDriver driver) {
        super(driver);
    }

    public void confirmarIdade() {
        //botaoSim().click();
    }

    public void apostar() {
        aposteJaBotao().click();
        megaSenaAposteAgoraLink().click();
    }

}
