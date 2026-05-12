import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void openGoogle() {
        driver.get("https://www.google.com");
    }

    public static void main(String[] args) {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String searchText = "manual testing ";

        driver.get("https://www.google.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")))
                .sendKeys(searchText);

        openGoogle();
        search(searchText);
        validate(searchText);

        driver.quit();
    }

    public static void search(String text) {

        //click Google Search button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='btnK']")))
                .click();
    }

    public static void validate(String text) {
        wait.until(ExpectedConditions.titleContains("Google"));

        String title = driver.getTitle();
        System.out.println("Page title : " + title);

        if (title.toLowerCase().contains("testing")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

}
