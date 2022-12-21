package attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MegaSenaAttributes extends BasicWebDriverInheritanceClass {

    public MegaSenaAttributes(WebDriver driver) {
        super(driver);
    }

    protected WebElement bola(int ball) {
        String locator = "//li/a[@id='n" + String.format("%02d", ball) + "']";
        WebElement selectedBall = driver.findElement(By.xpath(locator));
        return selectedBall;
    }

    protected WebElement colocarCarrinho() {
        return driver.findElement((By.id("colocarnocarrinho")));
    }

}
