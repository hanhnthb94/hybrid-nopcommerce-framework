package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

public class Lever_01_Repeat_Yourself {
    WebDriver driver;
    String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    String fullName = firstName + " " + lastName;
    String company = "Selenium WebDrive";
    String day = "15", month = "November", year = "1950";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Register() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector(".ico-register")).click();

        driver.findElement(By.cssSelector("#gender-male")).click();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(this.day);
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(this.month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(this.year);

        driver.findElement(By.cssSelector("#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("#Company")).sendKeys(company);
        driver.findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector(".ico-login")).click();
        driver.findElement(By.cssSelector("#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        driver.findElement(By.cssSelector(".ico-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input#gender-male")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), company);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getEmailAddress() {
        // Ham lay ra email random
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.com";
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }
}
