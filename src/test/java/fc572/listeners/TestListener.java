package fc572.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.logging.Logger;

public class TestListener implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(TestListener.class.getName());

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.severe("Test failed: " + result.getName());
        // Add screenshot capture logic here if needed
    }
}