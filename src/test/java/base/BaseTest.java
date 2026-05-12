package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebDriverWait getWait() {
        return wait.get();
    }

    public void setup() {

        String browser = ConfigReader.get("browser");

        WebDriver localDriver;

        switch (browser.toLowerCase()) {
            case "chrome":
                localDriver = new ChromeDriver();
                break;
            case "edge":
                localDriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser : " + browser);
        }

        driver.set(localDriver);

        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        wait.set(new WebDriverWait(localDriver, Duration.ofSeconds(10)));
    }

    public void teardown() {
        if (getDriver() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
        }
    }
}
