package com.example.myqaproject.tests;

import Utilities.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Optional: Allure Epic and Feature annotations for the whole class
@Epic("Web Application Regression Tests")
@Feature("Homepage Functionality")
public class ExampleTest extends Base {

    @BeforeMethod
    public void setup() {
        // Use Base class to initialize the driver (default to Chrome)
        initializeDriver("chrome");
        goToBaseUrl();
    }

    @Test
    @Description("Test to verify the Playwright page title")
    @Story("Homepage Tests")
    public void verifyPageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("Playwright"), "Page title does not contain 'Playwright'");
    }

    @Test
    @Description("Test to verify the Get Started link functionality")
    @Story("Homepage Tests")
    public void verifyGetStartedLink() {
        By getStartedLinkLocator = By.linkText("Get started");
        Assert.assertTrue(driver.findElements(getStartedLinkLocator).size() > 0);
        driver.findElement(getStartedLinkLocator).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after clicking link: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("/docs/intro"), "Current URL does contain '/docs/intro'");
    }

    @AfterMethod
    public void teardown() {
        tearDown();
    }
}