package pageObjects.techpanda;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techpanda.TechPandaPageUI;

public class TechPandaPageObject extends BasePage {
    private WebDriver driver;

    public TechPandaPageObject(WebDriver driver) {
        super();
        this.driver = driver;
    }
    public void clickToRegisterLink() {
        waitForElementVisible(driver, TechPandaPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, TechPandaPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, TechPandaPageUI.REGISTER_LINK);
    }
    public void enterRegisterValueTextbox(String restParams, String valueSend) {
        waitForElementVisible(driver, TechPandaPageUI.DYNAMIC_REGISTER_TEXTBOX, restParams);
        sendkeyToElement(driver, TechPandaPageUI.DYNAMIC_REGISTER_TEXTBOX, valueSend, restParams);
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, TechPandaPageUI.REGISTER_BUTTON);
        clickToElement(driver, TechPandaPageUI.REGISTER_BUTTON);
    }
    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, TechPandaPageUI.REGISTER_MESSAGE);
        return getElementText(driver, TechPandaPageUI.REGISTER_MESSAGE);
    }
    public void loginAsAdmin(String userName, String password) {
        sendkeyToElement(driver, TechPandaPageUI.USER_NAME_TEXTBOX, userName);
        sendkeyToElement(driver, TechPandaPageUI.PASSWORD_TEXTBOX, password);
        clickToElement(driver, TechPandaPageUI.LOGIN_BUTTON);
    }

    public void closePopup() {
        waitForElementClickable(driver, TechPandaPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, TechPandaPageUI.CLOSE_POPUP_BUTTON);
    }
    public void searchEmailUser(String emailAddress) {
        waitForElementVisible(driver, TechPandaPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, TechPandaPageUI.EMAIL_TEXTBOX, emailAddress);
        clickToElement(driver, TechPandaPageUI.SEARCH_BUTTON);
    }
    public String getValueUserInformation(String rowIndex, String columnIndex) {
        waitForElementVisible(driver, TechPandaPageUI.DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, columnIndex);
        return getElementText(driver, TechPandaPageUI.DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, columnIndex);
    }
}
