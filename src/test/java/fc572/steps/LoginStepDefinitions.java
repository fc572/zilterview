package fc572.steps;

import fc572.pages.LoginPage;
import fc572.platform.PlatformStrategy;
import fc572.platform.PlatformStrategyFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private PlatformStrategy platformStrategy;

    @Before
    public void setup(Scenario scenario) throws MalformedURLException, URISyntaxException {
        // Determine platform from scenario tags or name
        String platform = determinePlatform(scenario);

        platformStrategy = PlatformStrategyFactory.getStrategy(platform);
        driver = platformStrategy.createDriver();

        loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        driver.get(loginPage.getPageUrl());
    }

    @When("I enter username {string} and password {string}")
    public void loginWithCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the matrix page")
    public void iShouldBeRedirectedToTheMatrixPage() {
        System.out.println("you are matrix");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String determinePlatform(Scenario scenario) {
        return scenario.getName().contains("Mobile") ? "mobile" : "desktop";
    }

}