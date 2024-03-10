package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Loop {

    // final khong cho gan gia tri moi, va k lay gia tri o ngoai ham
    // Khong cho class khac ke thua
    // Ko cho cac class khac overide lai
    public static final String PI = "3.1418758475";

    public final void clickToElement() {}

    // static void cho gan gia tri o ngoai
    public static void clickToButton() throws InterruptedException {
        Thread.sleep(5000);
    }


    // Throw: dung trong ham try catch
    // throws: dung nem ra ngoai le

    public static void main(String[] args) throws InterruptedException {
        Topic_02_Loop topic02 = new Topic_02_Loop();
        topic02.clickToElement();

        Topic_02_Loop.clickToButton();
        System.out.println(Topic_02_Loop.PI);

        System.out.println("For: ");
        for (int i = 1; i<=10; i++) {
            if (i == 5) {
                System.out.println(i);
                break; // neu dieu kien la ==, thi can dung break de thoat vong lap, neu k thi no van kiem tra cac gia tri khac
            }
        }

        System.out.println("While: ");
        int i = 1;
        while (i <= 10) { // Kiem tra dieu kien trc roi moi thuc thi
            System.out.println(i);
            i++;
        }

        System.out.println("Do While: ");
        i = 1;
        do { // Thuc thi truoc it nhat 1 lan, roi moi kiem tra sau
            System.out.println(i);
            i++;
        } while (i <= 10);
    }
    public boolean isElementDisplayed() {
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(""));
        boolean status = false;
        try {
            status = element.isDisplayed();
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage());
        } finally { // step bat buoc phai chay neu co viet
            // Close ket noi/Clean du lieu
        }
    return status;
    }
}
