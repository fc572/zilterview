package fc572.driver;

import fc572.platform.PlatformStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesktopStrategy implements PlatformStrategy {
    @Override
    public WebDriver createDriver() {
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        return driver;
    }
}

