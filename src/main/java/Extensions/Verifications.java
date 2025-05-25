package Extensions;

import Utilities.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Verifications extends Base {
    /*
        Every test must end with an assertions, just like the "UIActions" class that wraps selenium actions to help us control them better
        here we wrap all of used assertions in our own methods to have a better control over the assertions. adding logs, Wait conditions, passing values and more
     */

    @Step("Verify text in element")
    public static void VerifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(), expected);
    }

    @Step("Verify text in element")
    public static void VerifyElementDisplayed(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertTrue(elem.isDisplayed());
    }

    @Step("Verify text in element")
    public static void VerifyStringsNotEqual(String elem1, String elem2){
        Assert.assertNotEquals(elem1, elem2);
    }
}
