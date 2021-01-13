package attributes;

import org.base.erbium.EElement;
import org.openqa.selenium.By;
import static utils.DriverManager.driver;


public class LoteriasCaixaAttributes {

    protected EElement botaoSim = driver().find(By.id("botaosim"));
    protected EElement aposteJaBotao = driver().find(By.xpath("//a[@class='btAposteJa ng-scope']"));
    protected EElement megaSenaAposteAgoraLink = driver().find(By.xpath("//a[@href='#/mega-sena']"));

    protected EElement botaoSim() {
        return driver().find(By.id("botaosim"));
    }

    protected EElement aposteJaBotao() {
        return driver().find(By.xpath("//a[@class='btAposteJa ng-scope']"));
    }

    protected EElement megaSenaAposteAgoraLink() {
        return driver().find(By.xpath("//a[@href='#/mega-sena']"));
    }

}
