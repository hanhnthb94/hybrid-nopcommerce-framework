package com.nopcommerce.users;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import static org.testng.Assert.assertEquals;

public class Lever_12_Dynamic_Locator_Rest_Param extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private DownloadableProductPageObject downloadableProductPage;
    private RewardPointPageObject rewardPointPage;
    private AddressesPageObject addressesPage;
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
    public void User_02_Switch_Multiple_Page() {
        downloadableProductPage = (DownloadableProductPageObject) customerPage.openDynamicSidebarPage("Downloadable products");
        addressesPage = (AddressesPageObject) downloadableProductPage.openDynamicSidebarPage("Addresses");
        rewardPointPage = (RewardPointPageObject) addressesPage.openDynamicSidebarPage("Reward points");
        customerPage = (CustomerPageObject) rewardPointPage.openDynamicSidebarPage("Customer info");
        addressesPage = (AddressesPageObject) customerPage.openDynamicSidebarPage("Addresses");
        downloadableProductPage = (DownloadableProductPageObject) addressesPage.openDynamicSidebarPage("Downloadable products");
    }
    @Test
    public void User_03_Switch_Multiple_Page() {
        downloadableProductPage.openDynamicSidebarPageByName("Addresses");
        addressesPage = PageGeneratorManager.getAddressesPage(driver);

        addressesPage.openDynamicSidebarPageByName("Reward points");
        rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);

        rewardPointPage.openDynamicSidebarPageByName("Customer info");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        customerPage.openDynamicSidebarPageByName("Addresses");
        addressesPage = PageGeneratorManager.getAddressesPage(driver);

        addressesPage.openDynamicSidebarPageByName("Downloadable products");
        downloadableProductPage = PageGeneratorManager.getDownloadableProductPage(driver);
    }

    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
