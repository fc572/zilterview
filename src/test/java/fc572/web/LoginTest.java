package fc572.web;

import fc572.config.Configuration;
import fc572.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String baseUrl;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        baseUrl = Configuration.getBaseUrl();
    }

    @Test
    void successfulLogin() {
        driver.get(baseUrl + "/loginPage.html");
        loginPage.login("Neo", "redpill");
        assertEquals("Fake Login Page", driver.getTitle());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

