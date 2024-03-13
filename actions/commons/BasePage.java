package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    public static BasePage getBasePage() {
        return new BasePage();
    }

    /*• 1- Access Modifier: public/protected/private/ default
• 2 - Kiểu dữ liệu của hàm (Data type): void/int/ String/ boolean/ WebElement/ List<WebElement>/..
■ Nó sẽ liên quan đến cái chức năng mình viết trong thân hàm
• 3 - Tên hàm: Đặt tên có nghĩa theo chức năng đang cần viết
  Dat ten gon gang giong van noi
I
■ Convention tuân theo chuẩn của từng ngôn ngữ lập trình (Java)
■ camelCase: từ đầu tiên viết thường - chữ cái đầu tiên của các từ tiếp theo sẽ viết hoa
• 4 - Có tham số hay ko (tùy vào chức năng cần viết)
     Dua vao ham cua Selenium minh goi ra de dung la gi
     // Web Browser: WebDriver driver
     // Web Element: WebDriver driver, String locator
• 5 - Kiểu dữ liệu trả về cho hàm
■ Nếu như có return dữ liệu thì sẽ khớp vs kiểu dữ liệu ở số 2
■ Nếu như có return thì nó là cái step cuối cùng*/

    // Action: click/ sendkey/ select/... khong tra ve du liệu thi dùng void
    /*public void clickToElement() {}

    public String getTextElement() {
        return null;
        // Dead Code = Unreachable statement
        // WebDriver driver;
    }*/

    // Return data: getText/ getAttribute/ getCss/ getSize/ getLocation/ getPosition
    // is

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

    public By getByXpath(String xpathExpression) {
        return By.xpath(xpathExpression);
    }
    public WebElement getElement(WebDriver driver, String xpathExpression) {
        return driver.findElement(getByXpath(xpathExpression));
    }
    public List<WebElement> getListElement(WebDriver driver, String xpathExpression) {
        return driver.findElements(getByXpath(xpathExpression));
    }
    public void clickToElement(WebDriver driver, String xpathExpression) {
        getElement(driver, xpathExpression).click();
    }
    public void senkeyToElement(WebDriver driver, String xpathExpression, String valueToSendkey) {
        // getElement(driver, xpathExpression).clear();
        getElement(driver, xpathExpression).sendKeys(valueToSendkey);
    }
    public String getElementText(WebDriver driver, String xpathExpression) {
        return getElement(driver, xpathExpression).getText();
    }


    public void selectDropdown(WebDriver driver, String xpathExpression, String itemText) {
        new Select(getElement(driver, xpathExpression)).selectByVisibleText(itemText);
    }
    public String getFirstSelectOption(WebDriver driver, String xpathExpression) {
        return new Select(getElement(driver, xpathExpression)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String xpathExpression) {
        return new Select(getElement(driver, xpathExpression)).isMultiple();
    }
    public void selectItemInDropdown(WebDriver driver, String parentCss, String childItemCss, String itemTextExpected) {
        getElement(driver, parentCss).click();
        sleepInSeconds(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemCss)));
        for (WebElement item: allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String xpathParent, String xpathChild, String ExpectedText) {
        getElement(driver, xpathParent).click();
        sleepInSeconds(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathChild)));
        for (WebElement tempElement: allItems) {
            if (tempElement.getText().equals(ExpectedText)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
                tempElement.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropdown(WebDriver driver, String parentCss, String childItemCss, String itemTextExpected) {
        getElement(driver, parentCss).clear();
        getElement(driver, parentCss).sendKeys(itemTextExpected);
        sleepInSeconds(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemCss)));
        for (WebElement item: allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String xpathExpression, String attributeName) {
        return getElement(driver, xpathExpression).getAttribute(attributeName);
    }
    public String getElementCssValue(WebDriver driver, String xpathExpression, String propertyName) {
        return getElement(driver, xpathExpression).getCssValue(propertyName);
    }
    public String getHexaColorByRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }
    public int getListElementSize(WebDriver driver, String xpathExpression) {
        return getListElement(driver, xpathExpression).size();
    }
    public void checkToCheckboxRadio(WebDriver driver, String xpathExpression) {
        if(!getElement(driver, xpathExpression).isSelected()) {
            getElement(driver, xpathExpression).click();
        }
    }
    public void uncheckToCheckbox(WebDriver driver, String xpathExpression) {
        if(getElement(driver, xpathExpression).isSelected()) {
            getElement(driver, xpathExpression).click();
        }
    }
    public  boolean isElementDisplayed(WebDriver driver, String xpathExpression) {
        return getElement(driver, xpathExpression).isDisplayed();
    }
    public  boolean isElementSelected(WebDriver driver, String xpathExpression) {
        return getElement(driver, xpathExpression).isSelected();
    }
    public  boolean isElementEnable(WebDriver driver, String xpathExpression) {
        return getElement(driver, xpathExpression).isEnabled();
    }
    public void swichToFrame(WebDriver driver, String xpathExpression) {
        driver.switchTo().frame(getElement(driver, xpathExpression));
    }
    public void swichToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
    public void hoverToElement(WebDriver driver, String xpathExpression) {
        new Actions(driver).moveToElement(getElement(driver, xpathExpression)).perform();
    }
    public void doubleClickToElement(WebDriver driver, String xpathExpression) {
        new Actions(driver).doubleClick(getElement(driver, xpathExpression)).perform();
    }
    public void rightClickToElement(WebDriver driver, String xpathExpression) {
        new Actions(driver).contextClick(getElement(driver, xpathExpression)).perform();
    }
    // HTML 4 dung dc, nhung HTML 6 k dung dc ham dragAndDropToElement:
    public void dragAndDropToElement(WebDriver driver, String sourceXpath, String targetXpath) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceXpath), getElement(driver, targetXpath)).perform();
    }
    public void sendkeyBoardToElement(WebDriver driver, String xpathExpression, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, xpathExpression), key).perform();
    }

    // JavaExcutor
    public Object executeForBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSeconds(3);
    }

    public void hightlightElement(WebDriver driver, String xpathExpression) {
        WebElement element = getElement(driver, xpathExpression);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathExpression) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, xpathExpression));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String xpathExpression) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathExpression));
    }

    public void scrollToElementOnDown(WebDriver driver, String xpathExpression) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, xpathExpression));
    }

    public void setAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver, xpathExpression));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathExpression, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, xpathExpression));
    }

    public void sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, xpathExpression));
    }

    public String getAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, xpathExpression));
    }

    public String getElementValidationMessage(WebDriver driver, String xpathExpression) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, xpathExpression));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathExpression) {
        return  (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, xpathExpression));
    }
    public void waitForElementVisible(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathExpression)));
    }
    public void waitForElementClickable(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(getByXpath(xpathExpression)));
    }
    public void waitForListElementVisible(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathExpression)));
    }
    public void waitForElementInvisible(WebDriver driver, String xpathExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathExpression)));
    }





















}
