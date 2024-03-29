package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.target.model.SessionID;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.grid.data.Session;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Topic_04_Driver_Infor {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());
        driver.quit();

        driver = new FirefoxDriver();
        sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());
        driver.quit();
    }


}
