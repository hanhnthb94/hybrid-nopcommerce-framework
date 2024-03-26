package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.RegisterPageObject;

import java.lang.reflect.Method;

public class Lever_18_Extent_V4 extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    private String company = "Selenium WebDrive";
    private String birthDay = "15", birthMonth = "November", birthYear = "1999";

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }
    @Test
    public void TC_01_Register_Validate(Method method) {
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());
        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
    }
    @Test
    public void TC_02_Register_Success(Method method) {
        registerPage = homePage.clickToRegisterLink();

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

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
    }


    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
