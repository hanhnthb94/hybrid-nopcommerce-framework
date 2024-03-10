package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class Lever_02_Apply_BasePage_02_Static {
    WebDriver driver;
    BasePage basePage;
    String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "123456";
    String fullName = firstName + " " + lastName;
    String company = "Selenium WebDrive";
    String day = "15", month = "November", year = "1950";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        // basePage = new BasePage();
        basePage = BasePage.getBasePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Register() {
        basePage.openUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.clickToElement(driver, "//input[@id='gender-male']");
        basePage.senkeyToElement(driver, "//input[@id='FirstName']", firstName);
        basePage.senkeyToElement(driver, "//input[@id='LastName']", lastName);

        basePage.selectDropdown(driver, "//select[@name='DateOfBirthDay']", this.day);
        basePage.selectDropdown(driver, "//select[@name='DateOfBirthMonth']", this.month);
        basePage.selectDropdown(driver, "//select[@name='DateOfBirthYear']", this.year);

        // driver.findElement(By.cssSelector("#Email")).sendKeys(emailAddress);
        basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.senkeyToElement(driver, "//input[@id='Company']", company);
        basePage.senkeyToElement(driver, "//input[@id='Password']", password);
        basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
        basePage.clickToElement(driver, "//button[@id='register-button']");

        assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

    }

    @Test
    public void TC_02_Login() {
        basePage.openUrl(driver,"https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-login']");
        basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.senkeyToElement(driver, "//input[@id='Password']", password);
        basePage.clickToElement(driver, "//button[@class='button-1 login-button']");

        Assert.assertTrue(basePage.getElement(driver, "//a[@class='ico-account' and text()='My account']").isDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        // automationhanh@gmail.com/123456
        basePage.clickToElement(driver, "//a[@class='ico-account']");
        Assert.assertTrue(basePage.getElement(driver, "//input[@id='gender-male']").isSelected());
        assertEquals(basePage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
        assertEquals(basePage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);
        assertEquals(basePage.getFirstSelectOption(driver, "//select[@name='DateOfBirthDay']"), day);
        assertEquals(basePage.getFirstSelectOption(driver, "//select[@name='DateOfBirthMonth']"), month);
        assertEquals(basePage.getFirstSelectOption(driver, "//select[@name='DateOfBirthYear']"), year);
        assertEquals(basePage.getElementAttribute(driver, "//input[@id='Email']", "value"), emailAddress);
        assertEquals(basePage.getElementAttribute(driver, "//input[@id='Company']", "value"), company);

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
