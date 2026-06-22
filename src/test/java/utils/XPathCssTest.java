package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class XPathCssTest {

    @Test
    public void loginUsingXPath() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://the-internet.herokuapp.com/login");

        driver.findElement(
                By.xpath("//input[@id='username']"))
                .sendKeys("tomsmith");

        driver.findElement(
                By.xpath("//input[@id='password']"))
                .sendKeys("SuperSecretPassword!");

        driver.findElement(
                By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(2000);

        String message =
                driver.findElement(By.id("flash"))
                        .getText();

        System.out.println(message);

        Assert.assertTrue(
                message.contains(
                        "You logged into a secure area"));

        driver.quit();
    }

    @Test
    public void loginUsingCssSelector() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://the-internet.herokuapp.com/login");

        driver.findElement(
                By.cssSelector("#username"))
                .sendKeys("tomsmith");

        driver.findElement(
                By.cssSelector("#password"))
                .sendKeys("SuperSecretPassword!");

        driver.findElement(
                By.cssSelector("button.radius"))
                .click();

        WebDriverWait wait =
                new WebDriverWait(
                        driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("flash")));

        String message =
                driver.findElement(By.id("flash"))
                        .getText();

        System.out.println(message);

        Assert.assertTrue(
                message.contains(
                        "You logged into a secure area"));

        driver.quit();
    }
}
