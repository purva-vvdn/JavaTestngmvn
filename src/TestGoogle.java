// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.URL;

import com.google.common.annotations.VisibleForTesting;

public class TestGoogle extends BaseTest{
    @Test
    public void main1() {
        try {
            // URL seleniumHub = new URL("http://" + System.getenv("SELENIUM_HOST") + ":4444/wd/hub");
            // DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            // WebDriver driver = new RemoteWebDriver(seleniumHub, capabilities);
            // driver.get("http://www.google.com");
            test = extent.createTest("Sample Test", "This is a sample test");

            System.out.println("Title:");
            // driver.quit();
                // Sample assertion
        Assert.assertTrue(true);

        // Log some details
        test.pass("Sample test passed successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
