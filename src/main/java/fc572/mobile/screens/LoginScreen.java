package fc572.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {
    @AndroidFindBy(id = "field_uname")
    @iOSXCUITFindBy(id = "field_uname")
    private WebElement usernameField;

    @AndroidFindBy(id = "field_pwd")
    @iOSXCUITFindBy(id = "field_pwd")
    private WebElement passwordField;

    @AndroidFindBy(id = "loginBtn")
    @iOSXCUITFindBy(id = "loginBtn")
    private WebElement loginButton;

    public LoginScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}