package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.users.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToGenderButton() {
        waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }
    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectBirthDay(String birthDay) {
        waitForElementVisible(driver, RegisterPageUI.BIRTH_DAY_SELECT);
        selectDropdown(driver, RegisterPageUI.BIRTH_DAY_SELECT, birthDay);
    }

    public void selectBirthMonth(String birthMonth) {
        waitForElementVisible(driver, RegisterPageUI.BIRTH_MONTH_SELECT);
        selectDropdown(driver, RegisterPageUI.BIRTH_MONTH_SELECT, birthMonth);
    }

    public void selectBirthYear(String birthYear) {
        waitForElementVisible(driver, RegisterPageUI.BIRTH_YEAR_SELECT);
        selectDropdown(driver, RegisterPageUI.BIRTH_YEAR_SELECT, birthYear);
    }

    public void enterEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterCompanyTextbox(String company) {
        waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
    }

    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_MESSAGE);
    }

    public HomePageObject clickToHomePageLogo() {
        waitForElementClickable(driver, RegisterPageUI.HOMEPAGE_LOGO_IMAGE);
        clickToElement(driver, RegisterPageUI.HOMEPAGE_LOGO_IMAGE);
        return PageGeneratorManager.getHomePage(driver);
    }
}
