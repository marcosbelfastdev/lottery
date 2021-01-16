package attributes;

import org.base.erbium.EElement;
import org.openqa.selenium.By;

import static utils.DriverManager.driver;

public class PortalLoteriasAttributes {

    protected EElement cliqueAposte() {
        return driver().find(By
                .xpath("//a[text()='Clique e aposte']"));
    }


}
