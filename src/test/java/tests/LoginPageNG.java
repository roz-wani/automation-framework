/*
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageNG {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
    }

    @Test
    public void testValidLogin() {

        loginPage.open();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        String message = loginPage.getMessage();

        System.out.println("Message : " + message);

        Assert.assertTrue(message.contains("secure area"));

        loginPage.logout();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

 */
