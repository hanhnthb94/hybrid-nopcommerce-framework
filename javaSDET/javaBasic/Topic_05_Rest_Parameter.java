package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

public class Topic_05_Rest_Parameter {
    String rewardPointLink = "//div[@class='listbox']//a[text()='Reward points']";
    String downloadableProductLink = "//div[@class='listbox']//a[text()='Downloadable products']";
    String sidebarLink = "//div[@class='listbox']//a[text()='%s']";
    // String dynamicLink = "//td[@data-key='females' and text()='384187']/following-sibling::td[@data-key='country' and text()='Afghanistan']" +
            // "/following-sibling::td[@data-key='males' and text()='407124']/following-sibling::td[@data-key='total' and text()='791312']";
    String dynamicCountryLink = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']" +
            "/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
    @Test
    public void TC_01_Rest_Param() {
        clickToElement(rewardPointLink);
        clickToElement(downloadableProductLink);
        clickToElement(sidebarLink,"Addresses");
        clickToElement(dynamicCountryLink, "384187", "Afghanistan", "407124", "791312");
    }
    public void clickToElement(String locatorValue) {
        System.out.println("Click to: " + locatorValue);
    }
    // 1 param
    public void clickToElement(String locatorValue, String pageName) {
        System.out.println("Click to before: " + locatorValue);
        locatorValue = String.format(locatorValue, pageName);
        System.out.println("Click to after: " + locatorValue);
    }
    // Ham de click vao 1 element ko co dinh voi bat ky tham so nao
    // Var Arguments = Rest parameter
    public void clickToElement(String locatorValue, String... values) {
        System.out.println("Click to before: " + locatorValue);
        locatorValue = String.format(locatorValue, (Object[]) values);
        System.out.println("Click to after: " + locatorValue);
    }

}
