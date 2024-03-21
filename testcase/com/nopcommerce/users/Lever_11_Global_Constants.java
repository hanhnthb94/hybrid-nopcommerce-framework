package com.nopcommerce.users;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.RegisterPageObject;

import static org.testng.Assert.assertEquals;

public class Lever_11_Global_Constants extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    private String company = "Selenium WebDrive";
    private String birthDay = "15", birthMonth = "November", birthYear = "1999";
    private String userUrl = GlobalConstants.DEV_USER_URL;
    private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register() {
        homePage = new HomePageObject(driver);
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
        assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        homePage = registerPage.clickToHomePageLogo();
        loginPage = homePage.clickToLoginLink();
        loginPage.enterEmailTextbox(emailAddress);
        loginPage.enterPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.getMyAccountLink().isDisplayed());

        customerPage = homePage.clickToMyAccountLink();
        Assert.assertTrue(customerPage.getGender().isSelected());
        assertEquals(customerPage.getFirstNameAttributeValue(), firstName);
        assertEquals(customerPage.getLastNameAttributeValue(), lastName);
        assertEquals(customerPage.getBirthDaySelected(), birthDay);
        assertEquals(customerPage.getBirthMonthSelected(), birthMonth);
        assertEquals(customerPage.getBirthYearSelected(), birthYear);
        assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
        assertEquals(customerPage.getCompanyAttributeValue(), company);
    }

    @Test
    public void User_02_Switch_Url() {
        homePage = customerPage.userAbleToLogout(driver);
        // Chuyen qua trang Admin
        homePage.openUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
        Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
        adminLoginPage = adminDashboardPage.adminAbleToLogout(driver);
        adminLoginPage.openUrl(driver, userUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
        loginPage = homePage.clickToLoginLink();
        homePage = loginPage.loginAsUser(emailAddress, password);
    }

    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
