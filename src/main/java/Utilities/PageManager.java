package Utilities;

import org.openqa.selenium.WebDriver;
import Pages.MainPage; // Correct import

public class PageManager extends Base {
    private WebDriver driver;
    private MainPage mainPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(driver);
        }
        return mainPage;
    }

    // Add more page getters as needed
}