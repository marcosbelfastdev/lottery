package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.base.erbium.BaseState;
import org.base.erbium.EDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class DriverManager {

    public static WebDriver webDriver;
    public static EDriver browser;

    public static void launchBrowser() {

        if (webDriver != null)
            return;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        webDriver = new ChromeDriver(options);

        BaseState baseState = new BaseState();
        baseState.setProjectName("Lottery");
        baseState.setEnvironment("PROD");
        baseState.setTestName("Apostas");
        baseState.setBaseStateUrl("http://loterias.caixa.gov.br/wps/portal/loterias");
        browser = baseState.execute(webDriver);
        browser.manage().window().maximize();
        browser.manage().deleteAllCookies();

    }

    public static EDriver driver() {
        return browser;
    }

    public static void quit() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

}
