package pageFactory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.HomPageUI;

public class HomePageObject extends BasePageFactory {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement registerLink;
    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginLink;
    @FindBy(xpath = "//a[@class='ico-account' and text()='My account']")
    WebElement myAccountLink;

    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(driver, registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(driver, loginLink);
    }

    public WebElement getMyAccountLink() {
        waitForElementVisible(driver, myAccountLink);
        return myAccountLink;
    }

    public void clickToMyAccountLink() {
        waitForElementVisible(driver, myAccountLink);
        clickToElement(driver, myAccountLink);
    }
}

