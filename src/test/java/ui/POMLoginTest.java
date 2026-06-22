package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class POMLoginTest {

    @Test
    public void loginUsingPOM() {

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://the-internet.herokuapp.com/login");

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.enterUsername("tomsmith");

        loginPage.enterPassword("SuperSecretPassword!");

        loginPage.clickLogin();

        driver.quit();
    }
}
