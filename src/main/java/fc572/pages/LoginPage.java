package fc572.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "field_uname")
    private WebElement usernameField;

    @FindBy(id = "field_pwd")
    private WebElement passwordField;

    @FindBy(id = "loginBtn")
    private WebElement loginButton;

    @FindBy(id = "demo")
    private WebElement demo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isWelcomeMessageDisplayed() {
        return demo.getText().contains("Matrix");
    }
}
