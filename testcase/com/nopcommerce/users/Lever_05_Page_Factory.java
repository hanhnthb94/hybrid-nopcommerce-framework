package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.*;

import java.time.Duration;
import java.util.Random;
import static org.testng.Assert.assertEquals;

public class Lever_05_Page_Factory extends BasePageFactory {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    private String company = "Selenium WebDrive";
    private String birthDay = "15", birthMonth = "November", birthYear = "1999";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Register() {
        homePage = new HomePageObject(driver);
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);
        registerPage.clickToGenderButton();
        registerPage.enterFirstNameTextbox(firstName);
        registerPage.enterLastNameTextbox(lastName);
        registerPage.selectBirthDay(this.birthDay);
        registerPage.selectBirthMonth(this.birthMonth);
        registerPage.selectBirthYear(this.birthYear);
        registerPage.enterEmailTextbox(emailAddress);
        registerPage.enterCompanyTextbox(company);
        registerPage.enterPasswordTextbox(password);
        registerPage.enterConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        registerPage.clickToHomePageLogo();
        homePage = new HomePageObject(driver);
        homePage.clickToLoginLink();
        loginPage = new LoginPageObject(driver);
        loginPage.enterEmailTextbox(emailAddress);
        loginPage.enterPasswordTextbox(password);
        loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.getMyAccountLink().isDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        homePage = new HomePageObject(driver);
        homePage.clickToMyAccountLink();
        customerPage = new CustomerPageObject(driver);
        Assert.assertTrue(customerPage.getGender().isSelected());
        assertEquals(customerPage.getFirstNameAttributeValue(), firstName);
        assertEquals(customerPage.getLastNameAttributeValue(), lastName);
        assertEquals(customerPage.getBirthDaySelected(), birthDay);
        assertEquals(customerPage.getBirthMonthSelected(), birthMonth);
        assertEquals(customerPage.getBirthYearSelected(), birthYear);
        assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
        assertEquals(customerPage.getCompanyAttributeValue(), company);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.com";
    }

}
