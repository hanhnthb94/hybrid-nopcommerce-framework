/*
package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import reportConfigs.ExtentTestManager;
import java.lang.reflect.Method;

public class Lever_18_Extent_V5 extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    private String company = "Selenium WebDrive";
    private String birthDay = "15", birthMonth = "November", birthYear = "1999";

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        this.browserName = browserName;
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }
    @Test
    public void TC_01_Register_Validate(Method method) {
        ExtentTestManager.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "TC_01_Register_Validate");

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 01: Verify register link is displayed");
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 02: Click to register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 03: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify error Message at FirstName textbox");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 05: Verify error Message at LastName textbox");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
    }
    @Test
    public void TC_02_Register_Success(Method method) {
        ExtentTestManager.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "TC_02_Register_Success");

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 06: Click to Gender button");
        registerPage.refreshCurrentPage(driver);

        registerPage.clickToGenderButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify enter FirstName textbox is " + firstName);
        registerPage.enterFirstNameTextbox(firstName);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify enter LastName textbox is" + lastName);
        registerPage.enterLastNameTextbox(lastName);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify select BirthDay dropdown is" + birthDay);
        registerPage.selectBirthDay(this.birthDay);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify select BirthMonth dropdown is" + birthMonth);
        registerPage.selectBirthMonth(this.birthMonth);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify select BirthYear dropdown is" + birthYear);
        registerPage.selectBirthYear(this.birthYear);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify enter Email textbox is" + emailAddress);
        registerPage.enterEmailTextbox(emailAddress);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify enter Company textbox is" + company);
        registerPage.enterCompanyTextbox(company);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify enter Password textbox is" + password);
        registerPage.enterPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify enter ConfirmPassword textbox is" + password);
        registerPage.enterConfirmPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 03: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register - Steps 04: Verify Success Message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
    }
    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
*/
