package com.example.myqaproject.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

// Optional: Allure Epic and Feature annotations for the whole class
@Epic("Web Application Regression Tests")
@Feature("Homepage Functionality")
public class ExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Use WebDriverManager to setup the driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Example implicit wait
    }

    @Test
    @Description("Test to verify the Playwright page title")
    @Story("Homepage Tests")
    public void verifyPageTitle() {
        // Navigate to the specified URL
        driver.get("https://playwright.dev/");

        // Get the page title
        String pageTitle = driver.getTitle();

        // Log the title (optional, but good for debugging)
        System.out.println("Page Title: " + pageTitle);

        // Assert that the page title contains "Playwright"
        Assert.assertTrue(pageTitle.contains("Playwright"), "Page title does not contain 'Playwright'");
    }

    @Test
    @Description("Test to verify the Get Started link functionality")
    @Story("Homepage Tests")
    public void verifyGetStartedLink() {
        // Navigate to the specified URL
        driver.get("https://playwright.dev/");

        // Find the "Get started" link by its text
        By getStartedLinkLocator = By.linkText("Get started");

        // Ensure the element is found before clicking
        Assert.assertTrue(driver.findElements(getStartedLinkLocator).size() > 0, "Get started link not found");

        // Click the link
        driver.findElement(getStartedLinkLocator).click();

        // Get the current URL after clicking
        String currentUrl = driver.getCurrentUrl();

        // Log the current URL
        System.out.println("Current URL after clicking link: " + currentUrl);

        // Assert that the current URL contains "/docs/intro"
        Assert.assertTrue(currentUrl.contains("/docs/intro"), "Current URL does not contain '/docs/intro'");
    }

    @AfterMethod
    public void teardown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }
}