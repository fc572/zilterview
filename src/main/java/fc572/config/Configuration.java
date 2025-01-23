package fc572.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final Logger logger = LogManager.getLogger(Configuration.class);
    private static final Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
        } catch (IOException e) {
            logger.error("Error loading configuration: " + e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return props.getProperty("base.url", "http://localhost:3000");
    }

    public static String getBrowserType() {
        return props.getProperty("browser.type", "chrome");
    }
}