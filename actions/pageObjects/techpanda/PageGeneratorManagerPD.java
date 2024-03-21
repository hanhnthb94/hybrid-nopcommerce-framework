package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerPD {

    public static UserHomePageObject getHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }
    public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }
    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }

}
