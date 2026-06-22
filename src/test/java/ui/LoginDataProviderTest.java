package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LoginPagePF;
import utils.ExcelUtils;

public class LoginDataProviderTest {

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {

        return ExcelUtils.readExcel(
                "C:\\Users\\rozwani.zulkiflee\\Music\\LoginData.xlsx"
        );
    }

    @Test(dataProvider = "loginData")
    public void loginTest(
            String username,
            String password,
            String expectedResult) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get(
                "https://the-internet.herokuapp.com/login");

        LoginPagePF page = new LoginPagePF(driver);

        page.login(username, password);

        Thread.sleep(2000);

        String message = page.getMessage();

        if (expectedResult.equalsIgnoreCase("SUCCESS")) {

            Assert.assertTrue(
                    message.contains(
                            "Wawawa"));
        } else {

            Assert.assertTrue(
                    message.contains(
                            "Your username is invalid")
                    ||
                            message.contains(
                                    "Your password is invalid"));
        }

        driver.quit();

    }
}
