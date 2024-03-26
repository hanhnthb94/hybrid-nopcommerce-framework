package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Lever_17_ReportNG extends BaseTest {
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
    }
    @Test
    public void TC_01_Register_Validate() {
        log.info("Register - Steps 01: Verify register link is displayed");
        verifyFalse(homePage.isRegisterLinkDisplayed());

        log.info("Register - Steps 02: Click to register link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Steps 03: Click to register button");
        registerPage.clickToRegisterButton();

        log.info("Register - Steps 04: Verify error Message at FirstName textbox");
        verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        log.info("Register - Steps 05: Verify error Message at LastName textbox");
        verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");
    }
    @Test
    public void TC_02_Register_Success() {
        log.info("Register - Steps 06: Click to Gender button");
        registerPage.clickToGenderButton();

        log.info("Register - Steps 04: Verify enter FirstName textbox is " + firstName);
        registerPage.enterFirstNameTextbox(firstName);

        log.info("Register - Steps 04: Verify enter LastName textbox is" + lastName);
        registerPage.enterLastNameTextbox(lastName);

        log.info("Register - Steps 04: Verify select BirthDay dropdown is" + birthDay);
        registerPage.selectBirthDay(this.birthDay);

        log.info("Register - Steps 04: Verify select BirthMonth dropdown is" + birthMonth);
        registerPage.selectBirthMonth(this.birthMonth);

        log.info("Register - Steps 04: Verify select BirthYear dropdown is" + birthYear);
        registerPage.selectBirthYear(this.birthYear);

        log.info("Register - Steps 04: Verify enter Email textbox is" + emailAddress);
        registerPage.enterEmailTextbox(emailAddress);

        log.info("Register - Steps 04: Verify enter Company textbox is" + company);
        registerPage.enterCompanyTextbox(company);

        log.info("Register - Steps 04: Verify enter Password textbox is" + password);
        registerPage.enterPasswordTextbox(password);

        log.info("Register - Steps 04: Verify enter ConfirmPassword textbox is" + password);
        registerPage.enterConfirmPasswordTextbox(password);

        log.info("Register - Steps 03: Click to register button");
        registerPage.clickToRegisterButton();

        log.info("Register - Steps 04: Verify Success Message is displayed");
        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
    }


    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
