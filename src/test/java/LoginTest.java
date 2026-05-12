import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.ConfigReader;

public class LoginTest {

    public static String[][] readExcel(String filePath) throws Exception {

        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] data = new String[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sheet.getRow(i) != null && sheet.getRow(i).getCell(j) != null) {
                    data [i - 1][j] = sheet.getRow(i).getCell(j).toString();
                } else {
                    data[i - 1][j] = "";
                }
            }
        }

        workbook.close();
        return data;
    }

    static WebDriver driver;
    static  WebDriverWait wait;

    public static void login(String username, String password) {

        driver.get(ConfigReader.get("baseUrl"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        var userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        userField.clear();
        userField.sendKeys(username);

        var passField = driver.findElement(By.id("password"));
        passField.clear();
        passField.sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();
    }

    public static void validate(String expectedMessage) {

        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")))
                .getText();

        System.out.println("Message : " + message);

        if (message.contains(expectedMessage)) {
            System.out.println("Test Passed");

            //logout only if success
            if (expectedMessage.contains("secure area")) {
                driver.findElement(By.xpath("//a[@href='/logout']")).click();

                //wait until login page is back
                wait.until(ExpectedConditions.urlContains("login"));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            }

        } else {
            System.out.println("Test Failed");
        }
    }

    public static void main(String[] args) throws Exception{

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String[][] testData = readExcel("C:\\Users\\rozwani.zulkiflee\\Music\\testdata.xlsx");

        for (int i = 0; i < testData.length; i++) {

            String username = testData[i][0];
            String password = testData[i][1];
            String expectedMessage = testData[i][2];

            //skip empty row
            if (username == null || username.trim().isEmpty()) {
                continue;
            }

            System.out.println("Running Test Case " + (i + 1));

            login(username, password);
            validate(expectedMessage);
        }

        driver.quit();
    }
}
