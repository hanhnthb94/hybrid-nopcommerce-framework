package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Keywords {
    // Co cac ham non-abstract
    public void clickToElement() {
        // Co phan than (body)
    }
    // Khong dc chua cac ham abstract
    // public abstract void selectToDropdown() {}

    // Kieu du lieu nguyen thuy (Primitive Type)
    char c = 'a';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1000;
    float fNumber = 15.7f;
    double dNumber = 45.88d;
    boolean bStatus = true;

    // Kieu du lieu tham chieu (Reference Type)
    String fullName = "Automation Test";

    // Ham nay ko can tra ve gi het
    void clickToLoginButton() {}

    // Ham nay can tra ve du lieu kieu String
    String getLoginMessage() {
        // Bat buoc phai return
        // Chi duoc return 1 lan
        return "";
    }

    // Bat ky 1 class nao cung dc truy cap vao bien nay dc
    public String address = "145 Hoang Cau - Long Bien - Ha Noi";

    // Bien protected chỉ những class nao ke thua class nay moi dc su dung
    protected String city = "TP Ho Chi Minh";

    // Bien nay chi trong class nay moi sd dc
    private String phone = "0987654321";

    // Bien default dc sd trong Package nay
    String zipCode = "650000";

    // package: define xem class/interface nam trong package nao

    WebDriver driver;
    // Bieu thuc dieu kien:
    public WebDriver getBrowserDriver(String browserName) {
        if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new EdgeDriver();
        }

        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
            case "chrome":
                driver = new ChromeDriver();
            default:
                driver = new EdgeDriver();
        }

        // Vong lap
        for (int i = 0; i<10; i++) {
            System.out.println(i);
        }

            return driver;
    }





























}
