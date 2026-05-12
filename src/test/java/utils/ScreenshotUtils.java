package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + testName + ".png";

            File dest = new File(path);
            dest.getParentFile().mkdirs(); // create folder if not exist

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved : " + path);

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
