package fc572.driver;

import fc572.config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class AppiumDriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
        AppiumConfig appiumConfig = AppiumConfig.getInstance();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(appiumConfig.getDeviceName())
                .setAutomationName(appiumConfig.getAutomationName())
                .setPlatformName(appiumConfig.getPlatformName())
                .withBrowserName(appiumConfig.getBrowserName())
                .setNoReset(true)
                .setAutoGrantPermissions(true)
                .setChromedriverExecutable(System.getProperty("user.home") + appiumConfig.getPathToDriver());

        // Merge Chrome options
        options.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        try {
            driver.set(new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options));
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize Appium driver", e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}