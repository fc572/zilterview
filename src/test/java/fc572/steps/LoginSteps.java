package fc572.steps;

import fc572.config.Configuration;
import fc572.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private String baseUrl;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        baseUrl = Configuration.getBaseUrl();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String loginUrl = baseUrl + "/loginPage.html";
        driver.get(loginUrl);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_dashboard() {
        assertEquals("Fake Login Page", driver.getTitle());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

