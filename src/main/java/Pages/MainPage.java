package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By getStartedLinkLocator = By.className("getStarted_Sjon");
    private By docsNavLocator = By.linkText("Docs");
    private By searchInputLocator = By.cssSelector("input[placeholder='Search']");
    private By githubStarButtonLocator = By.cssSelector("a[href*='github.com/microsoft/playwright']");

    // Method to get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Method to click the "Get started" link
    public void clickGetStartedLink() {
        driver.findElement(getStartedLinkLocator).click();
    }

    // Method to check if the "Get started" link is present
    public boolean isGetStartedLinkPresent() {
        return driver.findElements(getStartedLinkLocator).size() > 0;
    }

    // Method to click the "Docs" navigation link
    public void clickDocsNav() {
        driver.findElement(docsNavLocator).click();
    }

    // Method to check if the search input is present
    public boolean isSearchInputPresent() {
        return driver.findElements(searchInputLocator).size() > 0;
    }

    // Method to click the GitHub star button
    public void clickGitHubStarButton() {
        driver.findElement(githubStarButtonLocator).click();
    }
}