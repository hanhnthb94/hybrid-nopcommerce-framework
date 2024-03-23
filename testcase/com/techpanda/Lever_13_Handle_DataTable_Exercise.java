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
import pageObjects.techpanda.TechPandaPageObject;
import static org.testng.Assert.assertEquals;

public class Lever_13_Handle_DataTable_Exercise extends BaseTest {
    private WebDriver driver;
    private TechPandaPageObject techPandaPage;
    private String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    private String fullName = firstName + " " + lastName;
    private String adminUrl = GlobalConstants.PANDA_ADMIN_URL;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
        techPandaPage = PageGeneratorManager.getTechPandaObject(driver);
    }
    @Test
    public void User_01_Register() {
        techPandaPage.clickToRegisterLink();
        techPandaPage.enterRegisterValueTextbox("firstname", firstName);
        techPandaPage.enterRegisterValueTextbox("lastname", lastName);
        techPandaPage.enterRegisterValueTextbox("email_address", emailAddress);
        techPandaPage.enterRegisterValueTextbox("password", password);
        techPandaPage.enterRegisterValueTextbox("confirmation", password);
        techPandaPage.clickToRegisterButton();
        assertEquals(techPandaPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    }
    @Test
    public void User_02_Switch_Url() {
        techPandaPage.openUrl(driver, adminUrl);
        techPandaPage.sleepInSeconds(2);
        techPandaPage.loginAsAdmin("user01", "guru99com");
        techPandaPage.closePopup();
        techPandaPage.searchEmailUser(emailAddress);
        techPandaPage.sleepInSeconds(2);
        Assert.assertEquals(techPandaPage.getValueUserInformation("1", "4"), emailAddress);
        Assert.assertEquals(techPandaPage.getValueUserInformation("1", "3"), fullName);
    }

    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
