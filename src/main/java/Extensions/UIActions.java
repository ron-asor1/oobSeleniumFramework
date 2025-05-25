package Extensions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Utilities.Base;


/*
    UIActions class will hold all of our used 'selenium actions' and wrap them in our own methods.
    this will help us control the actions better, such as waits, logs, reporting, Steps documentation and more
 */
public class UIActions extends Base {

    @Step("Click an element")
    public static void Click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Update an element")
    public static void UpdateText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        element.sendKeys(text);
    }

    @Step("Select element From Dropdown")
    public static void UpdateDropdown(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    @Step("Mouse hover an element")
    public static void MouseHover(WebElement elemOne, WebElement elemTwo){
        actions.moveToElement(elemOne).moveToElement(elemTwo).build().perform();

    }
}
