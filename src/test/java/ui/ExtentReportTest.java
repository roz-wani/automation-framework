package ui;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExtentManager;

public class ExtentReportTest {

    @Test
    public void sampleTest() {

        ExtentReports extent = ExtentManager.getInstance();

        ExtentTest test =
                extent.createTest("Login Test");

        test.info(
                "Starting Login Test");

        Assert.assertTrue(true);

        test.pass(
                "Test Passed");

        extent.flush();
    }
}
