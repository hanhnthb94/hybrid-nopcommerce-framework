package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.jquery.UploadPageObject;
import pageObjects.techpanda.TechPandaPageObject;
import pageObjects.user.*;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }
    public static CustomerPageObject getCustomerPage(WebDriver driver) {
        return new CustomerPageObject(driver);
    }
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }
    public static DownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {
        return new DownloadableProductPageObject(driver);
    }
    public static AddressesPageObject getAddressesPage(WebDriver driver) {
        return new AddressesPageObject(driver);
    }
    public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
        return new RewardPointPageObject(driver);
    }
    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }
    public static OrdersPageObject getOrdersPage(WebDriver driver) {
        return new OrdersPageObject(driver);
    }
    public static UploadPageObject getUploadPageObject(WebDriver driver) {
        return new UploadPageObject(driver);
    }
    public static TechPandaPageObject getTechPandaObject(WebDriver driver) {
        return new TechPandaPageObject(driver);
    }



}
