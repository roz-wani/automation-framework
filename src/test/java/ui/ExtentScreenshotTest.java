package ui;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class ExtentScreenshotTest {

    @Test
    public void extentScreenshotTest() throws Exception {

        ExtentReports extent =
                ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("Extent Screenshot Test");

        WebDriver driver =
                new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        try {

            Assert.assertTrue(true);

        } catch (Exception e) {

            ScreenshotUtils.capture(
                    driver, "LoginFailure");

            test.fail(
                    "Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(
                            "screenshots/LoginFauilure.png")
                            .build());

            throw e;

        } finally {

            driver.quit();
            extent.flush();
        }
    }
}
