package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.CustomerPageUI;

import java.time.temporal.ChronoUnit;

public class CustomerPageObject extends BasePage {
    private WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getGender() {
        waitForElementVisible(driver, CustomerPageUI.GENDER_MALE_RADIO);
        return getElement(driver, CustomerPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getBirthDaySelected() {
        waitForElementVisible(driver, CustomerPageUI.BIRTH_DAY_SELECT);
        return getFirstSelectOption(driver, CustomerPageUI.BIRTH_DAY_SELECT);
    }

    public String getBirthMonthSelected() {
        waitForElementVisible(driver, CustomerPageUI.BIRTH_MONTH_SELECT);
        return getFirstSelectOption(driver, CustomerPageUI.BIRTH_MONTH_SELECT);
    }

    public String getBirthYearSelected() {
        waitForElementVisible(driver, CustomerPageUI.BIRTH_YEAR_SELECT);
        return getFirstSelectOption(driver, CustomerPageUI.BIRTH_YEAR_SELECT);
    }

    public String getEmailAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.COMPANY_TEXTBOX, "value");
    }
}
