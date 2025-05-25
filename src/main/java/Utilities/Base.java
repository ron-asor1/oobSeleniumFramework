package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Base {
    protected static WebDriver driver;
    protected static String baseUrl = "https://playwright.dev/"; // Default main URL
    protected static PageManager pageManager;
    protected static WebDriverWait wait;
    protected static Actions actions;

    // Browser setup (default: Chrome)
    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
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

    public PageManager getPageManager() {
    return new PageManager(driver);
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