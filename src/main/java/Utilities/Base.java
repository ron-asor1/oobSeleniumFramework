package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Base {
    protected static WebDriver driver;
    protected static String baseUrl = "https://playwright.dev/"; // Default main URL

    // Browser setup (default: Chrome)
    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Navigate to the main URL
    public void goToBaseUrl() {
        driver.get(baseUrl);
    }

    // Optionally allow setting a custom base URL
    public void setBaseUrl(String url) {
        baseUrl = url;
    }

    // Get WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }

    // Clean up after tests
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}