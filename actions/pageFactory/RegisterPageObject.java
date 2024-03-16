package pageFactory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;
    @FindBy(xpath = "//div[@class='result']")
    WebElement registerMessage;
    @FindBy(xpath = "//input[@id='gender-male']")
    WebElement genderMaleRadio;
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameTextbox;
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameTextbox;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement birthDayDropdown;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement birthMonthDropdown;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement birthYearDropdown;
    @FindBy(xpath = "//input[@id='Company']")
    WebElement companyTextbox;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailTextbox;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordTextbox;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasswordTextbox;
    @FindBy(xpath = "//div[@class='header-logo']//img")
    WebElement homePageLogoImage;


    public void clickToGenderButton() {
        waitForElementClickable(driver, genderMaleRadio);
        clickToElement(driver, genderMaleRadio);
    }
    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        senkeyToElement(driver, firstNameTextbox, firstName);
    }

    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        senkeyToElement(driver, lastNameTextbox, lastName);
    }

    public void selectBirthDay(String birthDay) {
        waitForElementVisible(driver, birthDayDropdown);
        selectDropdown(driver, birthDayDropdown, birthDay);
    }

    public void selectBirthMonth(String birthMonth) {
        waitForElementVisible(driver, birthMonthDropdown);
        selectDropdown(driver, birthMonthDropdown, birthMonth);
    }

    public void selectBirthYear(String birthYear) {
        waitForElementVisible(driver, birthYearDropdown);
        selectDropdown(driver, birthYearDropdown, birthYear);
    }

    public void enterEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        senkeyToElement(driver, emailTextbox, emailAddress);
    }

    public void enterCompanyTextbox(String company) {
        waitForElementVisible(driver, companyTextbox);
        senkeyToElement(driver, companyTextbox, company);
    }

    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        senkeyToElement(driver, passwordTextbox, password);
    }

    public void enterConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        senkeyToElement(driver, confirmPasswordTextbox, password);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, registerMessage);
        return getElementText(driver, registerMessage);
    }

    public void clickToHomePageLogo() {
        waitForElementClickable(driver, homePageLogoImage);
        clickToElement(driver, homePageLogoImage);
    }
}
