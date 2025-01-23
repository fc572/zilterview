package fc572.platform;

import fc572.driver.DesktopStrategy;
import fc572.driver.MobileStrategy;

public class PlatformStrategyFactory {
    public static PlatformStrategy getStrategy(String platform) {
        return switch (platform.toLowerCase()) {
            case "desktop" -> new DesktopStrategy();
            case "mobile" -> new MobileStrategy();
            default -> throw new IllegalArgumentException("Unknown platform");
        };
    }
}
