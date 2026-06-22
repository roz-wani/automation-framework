package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorTest {

    @Test
    public void locatedElement() {

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://the-internet.herokuapp.com/login");

        WebElement username =
                driver.findElement(By.id("username"));

        username.sendKeys("farah");

        System.out.println(
                "Username field found");

        driver.quit();
    }
}
