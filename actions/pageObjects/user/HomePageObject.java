package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.users.HomPageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

        // Hàm khởi tạo của 1 class
        // Cùng tên vs Class
        // Không có kiểu trả về
        // Chạy đầu tiên khi class được gọi tới
        // 1 Class nếu ko được define hàm khởi tạo nào thì mặc định nó sẽ có 1 hàm khởi tạo rỗng
        // Nếu được define nó sẽ ưu tiên gọi tới hàm được define đó (ko dùng mặc định nữa)
        // Có thể có 1 hoặc nhiều tham số hoặc 0 tham số
        // 1 Class có thể có nhiều hàm khởi tạo
        // Nếu class hiện tại đang kế thừ 1 class cha thì khi tạo hàm khởi tạo nó sẽ có từ khó super
        // => Gọi khởi tạo đến hàm class cha
        // Nếu class hiện tại ko kế thừa class nào hết thì mặc định nó sẽ cho kế thừa class object

    @Step("Click to Register link")
    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, HomPageUI.REGISTER_LINK);
        clickToElement(driver, HomPageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    @Step("Click to Login link")
    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomPageUI.LOGIN_LINK);
        clickToElement(driver, HomPageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

    @Step("Get My Account link")
    public WebElement getMyAccountLink() {
        waitForElementVisible(driver, HomPageUI.MY_ACCOUNT_LINK);
        return getElement(driver, HomPageUI.MY_ACCOUNT_LINK);
    }

    @Step("Click to My Account link")
    public CustomerPageObject clickToMyAccountLink() {
        waitForElementVisible(driver, HomPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomPageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getCustomerPage(driver);
    }


    @Step("Verify Register link is display")
    public boolean isRegisterLinkDisplayed() {
        waitForElementVisible(driver, HomPageUI.REGISTER_LINK);
        return isElementDisplayed(driver, HomPageUI.REGISTER_LINK);
    }
}

