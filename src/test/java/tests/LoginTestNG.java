/*
package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelUtils;
import utils.ScreenshotUtils;
import utils.ExtentManager;

public class LoginTestNG  extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(LoginTestNG.class);

    LoginPage loginPage;
    ExtentReports extent;
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.readExcel(ConfigReader.get("excelPath"));
    }

    @BeforeClass
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void start() {
        setup(); //initialize driver FIRST
        loginPage = new LoginPage(getDriver(), getWait());
    }

    @Test (dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedMessage) {

        test.set(extent.createTest("Login Test : " + username + " | " + System.currentTimeMillis()));

        loginPage.open();
        loginPage.login(username, password);

        String message = loginPage.getMessage();

        Assert.assertTrue(
                message.toLowerCase().contains(expectedMessage.toLowerCase()),
                "Actual message : " + message
        );
    }

    @AfterMethod
    public void end(ITestResult result) {

        //if test FAIL
        if(ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName() + " - " + System.currentTimeMillis();

            ScreenshotUtils.capture(getDriver(), testName);

            test.get().fail("Test Failed",
                    MediaEntityBuilder
                            .createScreenCaptureFromPath("screenshots/" + testName + ".png")
                            .build());

        }
        teardown();

    }

    @AfterClass
    public void tearDownReport() {
        extent.flush();
    }
}
 */