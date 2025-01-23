package fc572.mobile;

import fc572.config.Configuration;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static fc572.driver.AppiumDriverManager.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileLoginTest extends BaseTest {
    private static final String LOGIN_URL = Configuration.getBaseUrl() + "/loginPage.html"; // Replace with your actual URL

    @Test
    public void testLogin() {
        // Create wait instance
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Navigate to the login page
        getDriver().get(LOGIN_URL);

        // Wait for and interact with elements using explicit waits
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("field_uname")));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("field_pwd")));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("loginBtn")));

        // Perform login actions
        usernameField.sendKeys("Neo");
        passwordField.sendKeys("redpill");
        loginButton.click();

        assertEquals("The Matrix - Wikipedia", getDriver().getTitle());
    }
}