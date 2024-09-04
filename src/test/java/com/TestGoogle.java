package com;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestGoogle extends BaseTest {

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        // Initialize Extent Reports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void main1() {
        try {
            // Setup WebDriver (uncomment and configure as needed)
            // URL seleniumHub = new URL("http://" + System.getenv("SELENIUM_HOST") + ":4444/wd/hub");
            // DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            // driver = new RemoteWebDriver(seleniumHub, capabilities);
            // Alternatively, use local WebDriver for testing
            driver = new ChromeDriver();

            // Initialize Extent Test
            test = extent.createTest("Google Homepage Test", "This test checks the Google homepage title.");

            // Test Steps
            test.info("Navigating to Google homepage.");
            driver.get("http://www.google.com");
            
            // Log the page title
            String title = driver.getTitle();
            test.info("Title of the page: " + title);

            // Sample assertion
            Assert.assertTrue(title.contains("Google"), "Title does not contain 'Google'");

            // Log test result
            test.pass("Test passed successfully, title contains 'Google'.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver
        if (driver != null) {
            driver.quit();
        }

        // Flush the Extent Report
        extent.flush();
    }
}
