package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.users.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {
    WebDriver driver;

    public SideBarMyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RewardPointPageObject openRewardPointPage() {
        waitForElementClickable(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
        clickToElement(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
        return PageGeneratorManager.getRewardPointPage(driver);
    }

    public DownloadableProductPageObject openDownloadableProductPage() {
        waitForElementClickable(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
        clickToElement(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
        return PageGeneratorManager.getDownloadableProductPage(driver);
    }

    public AddressesPageObject openAddressesPage() {
        waitForElementVisible(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
        clickToElement(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
        return PageGeneratorManager.getAddressesPage(driver);
    }

    public CustomerPageObject openCustomerInforPage() {
        waitForElementClickable(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
        clickToElement(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public SideBarMyAccountPageObject openDynamicSidebarPage(String pageName) {
        waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);

        switch (pageName) {
            case "Customer info":
                return PageGeneratorManager.getCustomerPage(driver);
            case "Addresses":
                return PageGeneratorManager.getAddressesPage(driver);
            case "Orders":
                return PageGeneratorManager.getOrdersPage(driver);
            case "Reward points":
                return PageGeneratorManager.getRewardPointPage(driver);
            case "Downloadable products":
                return PageGeneratorManager.getDownloadableProductPage(driver);
            default:
                new RuntimeException("Sidebar page name incorrect.");
                return null;
        }
    }
    public void openDynamicSidebarPageByName(String pageName) {
        waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
        clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
    }

}
