package pageObjects;

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


}
