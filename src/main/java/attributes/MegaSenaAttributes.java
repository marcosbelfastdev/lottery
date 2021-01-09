package attributes;

import org.base.erbium.EElement;
import org.openqa.selenium.By;
import static utils.DriverManager.driver;

public class MegaSenaAttributes {

    protected EElement bola(int ball) {
        //return driver().find(By.xpath("//ul[@class='escolhe-numero mega-sena']/li/a[@id='n" + String.valueOf(ball) +"']"));
        //return getWebElement(By.id("n"+String.valueOf(ball)));
        //driver().find(By.xpath("//div/[@class='escolhe-numero mega-sena']")).setFocus();
        //String.format("%02d", ball);
        String locator = "//li/a[@id='n" + String.format("%02d", ball) + "']";
        return driver().find(By.xpath(locator));
    }

    protected EElement colocarCarrinho() {
        return driver().find((By.id("colocarnocarrinho")));
    }

}
