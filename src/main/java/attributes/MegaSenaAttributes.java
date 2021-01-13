package attributes;

import org.base.erbium.Common;
import org.base.erbium.EElement;
import org.openqa.selenium.By;
import static utils.DriverManager.driver;

public class MegaSenaAttributes {

    protected EElement bola(int ball) {
        String locator = "//li/a[@id='n" + String.format("%02d", ball) + "']";
        EElement selectedBall = driver().find(By.xpath(locator));
        selectedBall.setOption(Common.HIGHLIGHT_ELEMENTS, false);
        return selectedBall;
    }

    protected EElement colocarCarrinho() {
        return driver().find((By.id("colocarnocarrinho")));
    }

}
