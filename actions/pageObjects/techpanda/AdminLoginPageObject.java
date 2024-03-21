package pageObjects.techpanda;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techpanda.AdminLoginPageUIPD;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public pageObjects.techpanda.AdminDashboardPageObject loginAsAdmin(String username, String password) {
        inputToUserNameTextbox(username);
        inputPasswordTextbox(password);
        clickToLoginButton();
        return PageGeneratorManagerPD.getAdminDashboardPage(driver);
    }

    public void inputToUserNameTextbox(String userName) {
        waitForElementInvisible(driver, AdminLoginPageUIPD.USER_NAME_TEXTBOX);
        getElement(driver, AdminLoginPageUIPD.USER_NAME_TEXTBOX).clear();
        sendkeyToElement(driver, AdminLoginPageUIPD.USER_NAME_TEXTBOX, userName);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementInvisible(driver, AdminLoginPageUIPD.PASSWORD_TEXTBOX);
        getElement(driver, AdminLoginPageUIPD.PASSWORD_TEXTBOX).clear();
        sendkeyToElement(driver, AdminLoginPageUIPD.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUIPD.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUIPD.LOGIN_BUTTON);
        return PageGeneratorManagerPD.getAdminDashboardPage(driver);
    }
}
