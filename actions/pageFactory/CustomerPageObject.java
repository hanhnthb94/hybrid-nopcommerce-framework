package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.CustomerPageUI;
import pageUIs.RegisterPageUI;

public class CustomerPageObject extends BasePageFactory{
    private WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // TestNG: @BeforeClass/ BeforeTest/ @Test/ @Parameter/...
    // UI: Annotation cua selenium:
    // @FindBy/ @FindBys/ @FindAll/ @CacheLookup
    @CacheLookup
    @FindBy(xpath = "//input[@id='gender-male']")
    WebElement genderMaleRadiobutton;
    @FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
    WebElement firstNameTextbox;
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameTextbox;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement birthDaySelected;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement birthMonthSelected;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement birthYearSelected;

    @FindBy(css = "input#Email")
    WebElement emailTextbox;
    @FindBy(xpath = "//input[@id='Company']")
    WebElement companyTextbox;
    @FindBy(css = "input#login")
    WebElement loginButton;

    // Action
    public WebElement getGender() {
        waitForElementVisible(driver, genderMaleRadiobutton);
        return genderMaleRadiobutton;
    }
    public String getFirstNameAttributeValue() {
        waitForElementVisible(driver, firstNameTextbox);
        return getElementAttribute(driver, firstNameTextbox, "value");
    }
    public String getLastNameAttributeValue() {
        waitForElementVisible(driver, lastNameTextbox);
        return getElementAttribute(driver, lastNameTextbox, "value");
    }

    public String getEmailAttributeValue() {
        waitForElementVisible(driver, emailTextbox);
        return getElementAttribute(driver, emailTextbox, "value");
    }

    public String getCompanyAttributeValue() {
        waitForElementVisible(driver, companyTextbox);
        return getElementAttribute(driver, companyTextbox, "value");
    }

    public String getBirthDaySelected() {
        waitForElementVisible(driver, birthDaySelected);
        return getFirstSelectOption(driver, birthDaySelected);
    }
    public String getBirthMonthSelected() {
        waitForElementVisible(driver, birthMonthSelected);
        return getFirstSelectOption(driver, birthMonthSelected);
    }
    public String getBirthYearSelected() {
        waitForElementVisible(driver, birthYearSelected);
        return getFirstSelectOption(driver, birthYearSelected);
    }

}
