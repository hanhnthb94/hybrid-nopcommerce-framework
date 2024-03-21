package com.techpanda;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.techpanda.*;
import pageObjects.user.*;

import static org.testng.Assert.assertEquals;

public class Lever_13_Handle_DataTable_Exercise extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    private String fullName = firstName + " " + lastName;
    private String userUrl = GlobalConstants.PANDA_USER_URL;
    private String adminUrl = GlobalConstants.PANDA_ADMIN_URL;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGeneratorManagerPD.getHomePage(driver);
    }
    @Test
    public void User_01_Register() {
        homePage = new UserHomePageObject(driver);
        registerPage = homePage.clickToRegisterLink();
        registerPage.enterRegisterValueTextbox("firstname", firstName);
        registerPage.enterRegisterValueTextbox("lastname", lastName);
        registerPage.enterRegisterValueTextbox("email_address", emailAddress);
        registerPage.enterRegisterValueTextbox("password", password);
        registerPage.enterRegisterValueTextbox("confirmation", password);
        registerPage.clickToRegisterButton();
        assertEquals(registerPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    }

    @Test
    public void User_02_Switch_Url() {
        registerPage.openUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManagerPD.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginAsAdmin("user01", "guru99com");
        adminDashboardPage.closePopup();
        adminDashboardPage.searchEmailUser(emailAddress);
        Assert.assertEquals(adminDashboardPage.getValueUserInformation("1", "4"), emailAddress);
        Assert.assertEquals(adminDashboardPage.getValueUserInformation("1", "3"), fullName);
    }


    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
