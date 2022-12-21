package attributes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoteriasCaixaAttributes extends BasicWebDriverInheritanceClass {

    protected WebDriver driver;

    public LoteriasCaixaAttributes(WebDriver driver) {
        super(driver);
    }


    protected WebElement botaoSim() {
        //return driver.findElement(By.id("botaosim"));
        return driver.findElement(By.linkText("Sim"));
    }

    protected WebElement aposteJaBotao() {
        return driver.findElement(By.xpath("//a[@class='btAposteJa ng-scope']"));
    }

    protected WebElement megaSenaAposteAgoraLink() {
        return driver.findElement(By.xpath("//a[@href='#/mega-sena']"));
    }

}
