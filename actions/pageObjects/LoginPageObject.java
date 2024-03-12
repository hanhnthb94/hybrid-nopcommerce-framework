package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomPageUI;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void enterEmailTextbox(String emailAddress) {
        waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
        senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }
    public void enterPasswordTextbox(String password) {
        waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
        senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }
    public void clickToLoginButton() {
        //waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

}
