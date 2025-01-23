package fc572.mobile;


import fc572.driver.AppiumDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setup() {
        AppiumDriverManager.initializeDriver();
    }

    @AfterTest
    public void tearDown() {
        AppiumDriverManager.quitDriver();
    }
}
