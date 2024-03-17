package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminDashboardPageUI;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
        inputToEmailTextbox(emailAddress);
        inputPasswordTextbox(password);
        clickToLoginButton();
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public void inputToEmailTextbox(String emailAddres) {
        waitForElementInvisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        getElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX).clear();
        senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddres);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementInvisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        getElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX).clear();
        senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }
}
