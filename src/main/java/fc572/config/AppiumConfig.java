package fc572.config;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
public class AppiumConfig {
    private static final Properties props = new Properties();
    private static AppiumConfig instance;

    private String appiumServerUrl;
    private String platformName;
    private String deviceName;
    private String appPackage;
    private String appActivity;
    private String automationName;
    private String browserName;
    private String pathToDriver;

    private AppiumConfig() {
        try {
            props.load(new FileInputStream("src/test/resources/appium.properties"));
            this.appiumServerUrl = props.getProperty("appium.server.url", "http://localhost:4723");
            this.platformName = props.getProperty("platform.name", "Android");
            this.deviceName = props.getProperty("device.name", "Pixel_6_API_33");
            this.appPackage = props.getProperty("app.package");
            this.appActivity = props.getProperty("app.activity");
            this.automationName = props.getProperty("automation.name", "UiAutomator2");
            this.browserName = props.getProperty("browser", "Chrome");
            this.pathToDriver = props.getProperty("path.to.driver", "/.cache/appium/chromedriver");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load appium.properties", e);
        }
    }

    public static AppiumConfig getInstance() {
        if (instance == null) {
            instance = new AppiumConfig();
        }
        return instance;
    }


    public String getDeviceName() {
        return "emulator-5554";  // This matches your connected emulator
    }

    public String getAutomationName() {
        return "UiAutomator2";
    }

    public String getPlatformName() {
        return "Android";
    }
}
