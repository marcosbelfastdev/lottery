package attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PortalLoteriasAttributes extends BasicWebDriverInheritanceClass {

    public PortalLoteriasAttributes(WebDriver driver) {
        super(driver);
    }

    protected WebElement cliqueAposte() {
        return driver.findElement(By
                .xpath("//a[text()='Clique e aposte']"));
    }


}
