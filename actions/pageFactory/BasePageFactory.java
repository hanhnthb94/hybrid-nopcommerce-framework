package pageFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePageFactory {
    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }
    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }
    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }
    public void acceptToAlert(WebDriver driver) {
        // driver.switchTo().alert().accept();
        waitForAlertPresence(driver).accept();
    }
    public void cancelToAlert(WebDriver driver) {
        // driver.switchTo().alert().dismiss();
        waitForAlertPresence(driver).dismiss();
    }
    public String getAlertText(WebDriver driver) {
        // return driver.switchTo().alert().getText();
        return waitForAlertPresence(driver).getText();
    }
    public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
        // driver.switchTo().alert().sendKeys(valueToSendkey);
        waitForAlertPresence(driver).sendKeys(valueToSendkey);
    }
    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    // WINDOWS
    public void switchToWindowByID(WebDriver driver, String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id: allIDs) {
            if (!id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }
    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id: allIDs) {
            // switch truoc
            driver.switchTo().window(id);
            sleepInSeconds(2);
            // Lay ra title cua
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }
    public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id: allIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    public void sleepInSeconds ( long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }
    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }
    public void senkeyToElement(WebDriver driver, WebElement element, String valueToSendkey) {
        element.clear();
        element.sendKeys(valueToSendkey);
    }
    public String getElementText(WebDriver driver, WebElement element) {
        return element.getText();
    }
    public void selectDropdown(WebDriver driver, WebElement element, String itemText) {
        new Select(element).selectByVisibleText(itemText);
    }
    public String getFirstSelectOption(WebDriver driver, WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

}
