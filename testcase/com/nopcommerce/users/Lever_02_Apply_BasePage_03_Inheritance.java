package com.nopcommerce.users;

import commons.BasePage;
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

import static org.testng.Assert.assertEquals;

public class Lever_02_Apply_BasePage_03_Inheritance extends BasePage{
    WebDriver driver;

    String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    String fullName = firstName + " " + lastName;
    String company = "Selenium WebDrive";
    String day = "15", month = "November", year = "1950";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Register() {
        openUrl(driver,"https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[@class='ico-register']");

        clickToElement(driver, "//input[@id='gender-male']");
        sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendkeyToElement(driver, "//input[@id='LastName']", lastName);

        selectDropdown(driver, "//select[@name='DateOfBirthDay']", this.day);
        selectDropdown(driver, "//select[@name='DateOfBirthMonth']", this.month);
        selectDropdown(driver, "//select[@name='DateOfBirthYear']", this.year);

        // driver.findElement(By.cssSelector("#Email")).sendKeys(emailAddress);
        sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendkeyToElement(driver, "//input[@id='Company']", company);
        sendkeyToElement(driver, "//input[@id='Password']", password);
        sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
        clickToElement(driver, "//button[@id='register-button']");

        assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        openUrl(driver,"https://demo.nopcommerce.com/");
        clickToElement(driver, "//a[@class='ico-login']");
        sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendkeyToElement(driver, "//input[@id='Password']", password);
        clickToElement(driver, "//button[@class='button-1 login-button']");

        Assert.assertTrue(getElement(driver, "//a[@class='ico-account' and text()='My account']").isDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        // automationhanh@gmail.com/123456
        clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(getElement(driver, "//input[@id='gender-male']").isSelected());
        assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        assertEquals(getFirstSelectOption(driver, "//select[@name='DateOfBirthDay']"), day);
        assertEquals(getFirstSelectOption(driver, "//select[@name='DateOfBirthMonth']"), month);
        assertEquals(getFirstSelectOption(driver, "//select[@name='DateOfBirthYear']"), year);
        assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), emailAddress);
        assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), company);

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

}
