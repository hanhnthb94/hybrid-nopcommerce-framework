package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class TechPanda {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login() {
        driver.get("http://live.techpanda.org/index.php/backendlogin");
        sleepInSeconds(5);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user01");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("guru99com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleepInSeconds(3);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds ( long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress () {
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.com";

    }
}