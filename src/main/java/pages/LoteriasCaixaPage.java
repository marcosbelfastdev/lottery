package pages;

import attributes.LoteriasCaixaAttributes;
import attributes.PortalLoteriasAttributes;

public class LoteriasCaixaPage extends LoteriasCaixaAttributes {

    public void confirmarIdade() {
        botaoSim.click();
    }

    public void apostar() {
        aposteJaBotao.click();
        megaSenaAposteAgoraLink.click();
    }

}
