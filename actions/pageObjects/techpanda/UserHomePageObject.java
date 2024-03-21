package pageObjects.techpanda;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomPageUI;
import pageUIs.techpanda.UserHomPageUI;

import java.util.ArrayList;
import java.util.List;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementVisible(driver, UserHomPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomPageUI.REGISTER_LINK);
        return PageGeneratorManagerPD.getRegisterPage(driver);
    }
}

