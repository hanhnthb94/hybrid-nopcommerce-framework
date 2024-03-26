/*
package com.nopcommerce.users;

import com.relevantcodes.extentreports.LogStatus;
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
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class Lever_18_Extent_V2 extends BaseTest {
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
        ExtentManager.startTest(method.getName(), "TC_01_Register_Validate");
        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 01: Verify register link is displayed");
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 02: Click to register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 03: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify error Message at FirstName textbox");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 05: Verify error Message at LastName textbox");
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
    }
    @Test
    public void TC_02_Register_Success(Method method) {
        ExtentManager.startTest(method.getName(), "TC_02_Register_Success");
        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 06: Click to Gender button");
        registerPage.refreshCurrentPage(driver);

        registerPage.clickToGenderButton();

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify enter FirstName textbox is " + firstName);
        registerPage.enterFirstNameTextbox(firstName);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify enter LastName textbox is" + lastName);
        registerPage.enterLastNameTextbox(lastName);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify select BirthDay dropdown is" + birthDay);
        registerPage.selectBirthDay(this.birthDay);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify select BirthMonth dropdown is" + birthMonth);
        registerPage.selectBirthMonth(this.birthMonth);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify select BirthYear dropdown is" + birthYear);
        registerPage.selectBirthYear(this.birthYear);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify enter Email textbox is" + emailAddress);
        registerPage.enterEmailTextbox(emailAddress);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify enter Company textbox is" + company);
        registerPage.enterCompanyTextbox(company);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify enter Password textbox is" + password);
        registerPage.enterPasswordTextbox(password);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify enter ConfirmPassword textbox is" + password);
        registerPage.enterConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 03: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(LogStatus.INFO,"Register - Steps 04: Verify Success Message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
    }


    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
*/
