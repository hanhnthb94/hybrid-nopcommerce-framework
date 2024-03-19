package pageObjects;

import org.openqa.selenium.WebDriver;

public class DownloadableProductPageObject extends SideBarMyAccountPageObject {
    private WebDriver driver;

    public DownloadableProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
