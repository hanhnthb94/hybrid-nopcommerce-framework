package pageObjects.techpanda;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techpanda.AdminDashboardPageUIPD;

public class AdminDashboardPageObject extends BasePage {
    WebDriver driver;

    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopup() {
        waitForElementClickable(driver, AdminDashboardPageUIPD.CLOSE_POPUP_BUTTON);
        clickToElement(driver, AdminDashboardPageUIPD.CLOSE_POPUP_BUTTON);
    }


    public void searchEmailUser(String emailAddress) {
        waitForElementVisible(driver, AdminDashboardPageUIPD.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminDashboardPageUIPD.EMAIL_TEXTBOX, emailAddress);
    }

    public String getValueUserInformation(String rowIndex, String columnIndex) {
        waitForElementVisible(driver, AdminDashboardPageUIPD.DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, columnIndex);
        return getElementText(driver, AdminDashboardPageUIPD.DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, columnIndex);
    }

}
