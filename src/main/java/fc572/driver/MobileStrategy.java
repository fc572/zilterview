package fc572.driver;

import fc572.platform.PlatformStrategy;
import io.appium.java_client.AppiumDriver;

import static fc572.driver.AppiumDriverManager.getDriver;

public class MobileStrategy implements PlatformStrategy {
    @Override
    public AppiumDriver createDriver() {
        AppiumDriverManager.initializeDriver();
        return getDriver();
    }
}
