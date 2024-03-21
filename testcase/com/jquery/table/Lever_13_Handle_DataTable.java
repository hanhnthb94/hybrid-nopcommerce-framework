package com.jquery.table;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

import java.util.ArrayList;
import java.util.List;


public class Lever_13_Handle_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    List<String> allValueUI = new ArrayList<String>();
    List<String> allValueAPI = new ArrayList<String>();
    List<String> allValueDB = new ArrayList<String>();

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
    }
    @Test
    public void User_01_Search() {
        homePage.inputToColumnTextboxByName("Females", "283821");
        homePage.inputToColumnTextboxByName("Males", "295140");
        homePage.inputToColumnTextboxByName("Country", "Afghanistan");
        homePage.inputToColumnTextboxByName("Total", "791312");
    }

    @Test
    public void User_02_Paging() {
        homePage.clickToPageByNumber("10");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("10"));

        homePage.clickToPageByNumber("20");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("20"));
    }
    @Test
    public void User_03_Display() {
        homePage.inputToColumnTextboxByName("Country", "Antigua and Barbuda");
        Assert.assertTrue(homePage.isRowValuesDisplayed("777", "Antigua and Barbuda", "803", "1580"));
    }
    @Test
    public void User_04_Button_Checkbox() {
        homePage.clickToRowActionByCountryName("AFRICA", "edit");
        homePage.refreshCurrentPage(driver);
        homePage.clickToRowActionByCountryName("AFRICA", "remove");
        homePage.refreshCurrentPage(driver);
    }
    @Test
    public void User_05_Action_By_Index() {
        // UI
        allValueUI = homePage.getAllPageValuesByColumnName("Country");
        // API: Rest Assured/ Karate/...
        // allValueAPI = homePage.getAllPageValuesByColumnNameInAPI("Country");

        // DB: JTDS, SQL/...
        // allValueDB = homePage.getAllPageValuesByColumnNameInDB("");

        Assert.assertEquals(allValueUI, allValueDB);


        homePage.getAllPageValuesByColumnName("Total");
        // Bước 1: Lấy ra tất cả các page // Bước 2: Duyệt qua từng page
        // Bước 3: Lấy ra tất cả các giá trị của 1 cột trong cái page đó -> Lưu nó vào List/ Set/...
        // Bước 4: Duyệt hết các page còn lại

    }
    @Test
    public void User_06_Get_All_Row_Values() {
        homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        // Nhập vào textbox tại cột Contact Person dòng thứ 2
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Oliver Kahl");
        homePage.enterToTextboxByColumnNameAndRowIndex("Company", "1", "Bayer Munich");
        // Select dữ liệu tại cột Country dòng thứ 3
        homePage.selectDropdownByColumnNameAndRowIndex("Country", "3", "United Kingdom");
        homePage.selectDropdownByColumnNameAndRowIndex("Country", "1", "Japan");
        // Click vào checkbox tại cột NPO? dòng thứ 1
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "1");
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
    }


    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
