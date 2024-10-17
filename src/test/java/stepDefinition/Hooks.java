package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver webDriver;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("--headless=new");
        co.addArguments("--disable-gpu");
        co.addArguments("--window-size=1920,1080");
        co.addArguments("--no-sandbox");
        co.addArguments("--disable-extensions");
        webDriver = new ChromeDriver(co);
        String url = "https://www.automationexercise.com/";
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
