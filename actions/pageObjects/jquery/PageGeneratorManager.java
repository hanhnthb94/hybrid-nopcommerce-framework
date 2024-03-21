package pageObjects.jquery;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.*;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver) {
        return new pageObjects.jquery.HomePageObject(driver);
    }


}
