package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver webDriver;


    public WebDriver launchBrowser() {

        if (webDriver != null)
            return webDriver;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("--incognito");
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(10000L, TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        //baseState.setBaseStateUrl("http://loterias.caixa.gov.br/wps/portal/loterias");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));
        return webDriver;

    }


    public static void quit() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

}
