package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.*;
import pageUIs.BasePageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    public static BasePage getBasePage() {
        return new BasePage();
    }
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
        waitForAlertPresence(driver).accept();
    }
    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }
    public String getAlertText(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }
    public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
        waitForAlertPresence(driver).sendKeys(valueToSendkey);
    }
    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
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
            driver.switchTo().window(id);
            sleepInSeconds(2);
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
    public By getByLocator(String locatorValue) {
        By by = null;
        if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("Xpath=")) {
            by = By.xpath(locatorValue.substring(6));
        } else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("CSS=")) {
            by = By.cssSelector(locatorValue.substring(4));
        } else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=")) {
            by = By.id(locatorValue.substring(3));
        } else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=")) {
            by = By.name(locatorValue.substring(5));
        } else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLASS=")) {
            by = By.className(locatorValue.substring(6));
        } else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("TAGNAME=")) {
            by = By.tagName(locatorValue.substring(8));
        } else {
            throw new RuntimeException("Locator type is not valid");
        }
        return by;
    }

    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);
    }


    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }
    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public int getListElementSize(WebDriver driver, String locator, String... restParams) {
        return getListElement(driver, getDynamicLocator(locator, restParams)).size();
    }
    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }
    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String valueToSendkey, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).clear();
        getElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSendkey);
    }

    public void sendkeyToElement(WebDriver driver, String locator, String valueToSendkey) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(valueToSendkey);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }
    public String getElementText(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getText();
    }
    public void selectDropdown(WebDriver driver, String locator, String itemText) {
        new Select(getElement(driver, locator)).selectByVisibleText(itemText);
    }
    public void selectDropdown(WebDriver driver, String locator, String itemText, String... restParams) {
        new Select(getElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemText);
    }
    public String getFirstSelectOption(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }
    public void selectItemInDropdown(WebDriver driver, String parentCss, String childItemCss, String itemTextExpected) {
        getElement(driver, parentCss).click();
        sleepInSeconds(1);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemCss)));
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
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));
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
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemCss)));
        for (WebElement item: allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
    }
    public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }
    public String getHexaColorByRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }
    public int getListElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }
    public void checkToCheckboxRadio(WebDriver driver, String locator) {
        if(!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }
    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if(getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }
    public void checkToElement(WebDriver driver, String locator, String... restParams) {
        if(!getElement(driver, getDynamicLocator(locator, restParams)).isSelected()) {
            getElement(driver, getDynamicLocator(locator, restParams)).click();
        }
    }
    public  boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }
    public  boolean isElementDisplayed(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
    }
    public  boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }
    public  boolean isElementEnable(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }
    public void swichToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }
    public void swichToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }
    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }
    // HTML 4 dung dc, nhung HTML 6 k dung dc ham dragAndDropToElement:
    public void dragAndDropToElement(WebDriver driver, String sourceXpath, String targetXpath) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceXpath), getElement(driver, targetXpath)).perform();
    }
    public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
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
    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }
    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }
    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }
    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }
    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver, locator));
    }
    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }
    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }
    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }
    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }
    public boolean isImageLoaded(WebDriver driver, String locator) {
        return  (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
    }
    public boolean isPageLoadedSuccess(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        });
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }
    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }
    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForListElementInVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions
                .invisibilityOfAllElements(getListElement(driver, locator)));
    }
    public boolean waitForListElementInVisibleBoolean(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions
                .invisibilityOfAllElements(getListElement(driver, locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public boolean waitForElementInvisibleBoolean(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public RewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARD_POINT_PAGE_LINK);
        clickToElement(driver, BasePageUI.REWARD_POINT_PAGE_LINK);
        return PageGeneratorManager.getRewardPointPage(driver);
    }
    public DownloadableProductPageObject openDownloadableProductPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
        clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
        return PageGeneratorManager.getDownloadableProductPage(driver);
    }
    public AddressesPageObject openAddressesPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.ADDRESSES_PAGE_LINK);
        clickToElement(driver, BasePageUI.ADDRESSES_PAGE_LINK);
        return PageGeneratorManager.getAddressesPage(driver);
    }
    public CustomerPageObject openCustomerInforPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_PAGE_LINK);
        clickToElement(driver, BasePageUI.CUSTOMER_INFOR_PAGE_LINK);
        return PageGeneratorManager.getCustomerPage(driver);
    }
    public HomePageObject userAbleToLogout(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.USER_LOGOUT_LINK);
        clickToElement(driver, BasePageUI.USER_LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }
    public AdminLoginPageObject adminAbleToLogout(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADMIN_LOGOUT_LINK);
        clickToElement(driver, BasePageUI.ADMIN_LOGOUT_LINK);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
}
