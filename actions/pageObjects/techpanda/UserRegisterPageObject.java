package pageObjects.techpanda;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.user.HomePageObject;
import pageUIs.techpanda.UserRegisterPageUI;
import pageUIs.users.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterRegisterValueTextbox(String restParams, String valueSend) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_REGISTER_TEXTBOX, restParams);
        sendkeyToElement(driver, UserRegisterPageUI.DYNAMIC_REGISTER_TEXTBOX, valueSend, restParams);
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }
    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_MESSAGE);
    }

}
