package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.users.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Gender Male radio button")
    public void clickToGenderButton() {
        waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to First Name textbox with value is {0}")
    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to Last Name textbox with value is {0}")
    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Select to Birth day dropdown with value is {0}")
    public void selectBirthDay(String birthDay) {
        waitForElementVisible(driver, RegisterPageUI.BIRTH_DAY_SELECT);
        selectDropdown(driver, RegisterPageUI.BIRTH_DAY_SELECT, birthDay);
    }

    @Step("Select to Birth moth dropdown with value is {0}")
    public void selectBirthMonth(String birthMonth) {
        waitForElementVisible(driver, RegisterPageUI.BIRTH_MONTH_SELECT);
        selectDropdown(driver, RegisterPageUI.BIRTH_MONTH_SELECT, birthMonth);
    }

    @Step("Select to Birth year dropdown with value is {0}")
    public void selectBirthYear(String birthYear) {
        waitForElementVisible(driver, RegisterPageUI.BIRTH_YEAR_SELECT);
        selectDropdown(driver, RegisterPageUI.BIRTH_YEAR_SELECT, birthYear);
    }

    @Step("Enter to Last Email with value is {0}")
    public void enterEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Company textbox with value is {0}")
    public void enterCompanyTextbox(String company) {
        waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
    }

    @Step("Enter to Password textbox with value is {0}")
    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox with value is {0}")
    public void enterConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Get Register message")
    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_MESSAGE);
    }

    @Step("Click to Home page logo")
    public HomePageObject clickToHomePageLogo() {
        waitForElementClickable(driver, RegisterPageUI.HOMEPAGE_LOGO_IMAGE);
        clickToElement(driver, RegisterPageUI.HOMEPAGE_LOGO_IMAGE);
        return PageGeneratorManager.getHomePage(driver);
    }

    @Step("Get First Name error message")
    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
    }
    @Step("Get Last Name error message")
    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
    }
}
