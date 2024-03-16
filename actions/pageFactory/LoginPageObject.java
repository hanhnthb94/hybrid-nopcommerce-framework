package pageFactory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailTextbox;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordTextbox;

    public void enterEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        senkeyToElement(driver, emailTextbox, emailAddress);
    }
    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        senkeyToElement(driver, passwordTextbox, password);
    }
    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }

}
