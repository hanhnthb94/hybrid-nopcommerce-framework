package pageUIs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class BasePageUI  {
    public static final String REWARD_POINT_PAGE_LINK = "xpath=//div[@class='listbox']//a[text()='Reward points']";
    public static final String DOWNLOADABLE_PRODUCT_PAGE_LINK = "xpath=//div[@class='listbox']//a[text()='Downloadable products']";
    public static final String ADDRESSES_PAGE_LINK = "xpath=//div[@class='listbox']//a[text()='Addresses']";
    public static final String CUSTOMER_INFOR_PAGE_LINK = "xpath=//div[@class='listbox']//a[text()='Customer info']";
    public static final String USER_LOGOUT_LINK = "xpath=//a[text()='Log out']";
    public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
    public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
}
