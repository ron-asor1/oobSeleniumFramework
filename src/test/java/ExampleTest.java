// package com.example.my_qa_project.tests;
import Utilities.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainPage;

// Optional: Allure Epic and Feature annotations for the whole class
@Epic("Web Application Regression Tests")
@Feature("Homepage Functionality")
public class ExampleTest extends Base {

    MainPage mainPage;

    @BeforeMethod
    public void setup() {
        // Use Base class to initialize the driver (default to Chrome)
        initializeDriver("chrome");
        goToBaseUrl();
        mainPage = getPageManager().getMainPage();
    }

    @Test
    @Description("Test to verify the Playwright page title")
    @Story("Homepage Tests")
    public void verifyPageTitle() {
        String pageTitle = driver.getTitle();
        Assert.assertTrue(mainPage.getPageTitle().contains("Playwright"), 
                "Page title does not contain 'Playwright': " + pageTitle);
    }

    @Test
    @Description("Test to verify the Get Started link functionality")
    @Story("Homepage Tests")
    public void verifyGetStartedLink() {
        Assert.assertTrue(mainPage.isGetStartedLinkPresent());
        mainPage.clickGetStartedLink();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after clicking link: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("/docs/intro"), "Current URL does contain '/docs/intro'");
    }

    @AfterMethod
    public void teardown() {
        tearDown();
    }
}