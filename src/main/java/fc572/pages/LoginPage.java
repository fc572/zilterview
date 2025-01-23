package fc572.pages;

import fc572.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Use By locators that work across platforms
    private final By usernameLocator = By.id("field_uname");
    private final By passwordLocator = By.id("field_pwd");
    private final By loginButtonLocator = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageUrl() {
        return Configuration.getBaseUrl() + "/loginPage.html";
    }

    public void login(String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }
}