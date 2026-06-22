package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void successfullLogin() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username"))
                .sendKeys("tomsmith");

        driver.findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");

        driver.findElement(
                By.className("radius"))
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
}
