package fc572.platform;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface PlatformStrategy {
    WebDriver createDriver() throws MalformedURLException, URISyntaxException;  // Create platform-specific driver
}