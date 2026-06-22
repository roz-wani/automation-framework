package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class LoginPagePF {

    WebDriver driver;

    public LoginPagePF(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(
                driver, this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button.radius")
    WebElement loginBtn;

    @FindBy(id = "flash")
    WebElement flashMessage;

    public void login(
            String user,
            String pass) {

        username.sendKeys(user);

        password.sendKeys(pass);

        loginBtn.click();
    }

    public String getMessage() {

        return flashMessage.getText();
    }
}
