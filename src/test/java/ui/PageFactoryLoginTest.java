package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPagePF;

public class PageFactoryLoginTest {

    @Test
    public void loginUsingPageFactory() throws  Exception {

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://the-internet.herokuapp.com/login");

        LoginPagePF page = new LoginPagePF(driver);

        page.login(
                "tomsmith", "SuperSecretPassword!");

        Thread.sleep(2000);

        Assert.assertTrue(
                page.getMessage()
                        .contains("You logged into a secure area"));

        driver.quit();
    }
}
