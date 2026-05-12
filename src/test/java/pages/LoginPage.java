package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Locators
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By flashMsg = By.id("flash");
    By logoutBtn = By.xpath("//a[@href='/logout']");

    //Actions
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");

        wait.until(ExpectedConditions.urlContains("login")); //ensure correct page
        wait.until(driver -> driver.findElement(username).isDisplayed());

        System.out.println("Page title : " + driver.getTitle());
    }

    public void login(String user, String pass) {

        for (int i = 0; i < 2; i++) {
            try {
                WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
                userField.clear();
                userField.sendKeys(user);

                WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
                passField.clear();
                passField.sendKeys(pass);

                wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

                //wait for the page/message
                wait.until(ExpectedConditions.visibilityOfElementLocated(flashMsg));
                break;

            } catch (Exception e) {
                if (i == 1) throw e; //fail after retry
            }
        }


    }

    public String getMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flashMsg)).getText();
    }

    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
    }
}
