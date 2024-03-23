package com.jquery.upload;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.UploadPageObject;

import java.util.ArrayList;
import java.util.List;


public class Lever_14_Upload_File extends BaseTest {
    WebDriver driver;
    UploadPageObject uploadPage;
    String oneImg = "one.jpg";
    String twoImg = "two.jpg";
    String threeImg = "three.jpg";
    String[] fileNames = {oneImg, twoImg, threeImg};

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        uploadPage = PageGeneratorManager.getUploadPageObject(driver);
    }
    @Test
    public void User_01_Upload_Single_File() {
        uploadPage.uploadMultipleFiles(driver, oneImg);
        uploadPage.sleepInSeconds(2);
        uploadPage.uploadMultipleFiles(driver, twoImg);
        uploadPage.sleepInSeconds(2);
        uploadPage.uploadMultipleFiles(driver, threeImg);
        uploadPage.sleepInSeconds(2);
        Assert.assertTrue(uploadPage.isFileLoadSuccess(oneImg));
        Assert.assertTrue(uploadPage.isFileLoadSuccess(twoImg));
        Assert.assertTrue(uploadPage.isFileLoadSuccess(threeImg));
        uploadPage.clickStartButtonEachFile();
        Assert.assertTrue(uploadPage.isFileUpLoadSuccess(oneImg));
        Assert.assertTrue(uploadPage.isFileUpLoadSuccess(twoImg));
        Assert.assertTrue(uploadPage.isFileUpLoadSuccess(threeImg));
    }

    @Test
    public void User_02_Upload_Multiple_File() {
        uploadPage.refreshCurrentPage(driver);
        uploadPage.uploadMultipleFiles(driver, fileNames);
        uploadPage.sleepInSeconds(2);
        Assert.assertTrue(uploadPage.isFileLoadSuccess(oneImg));
        Assert.assertTrue(uploadPage.isFileLoadSuccess(twoImg));
        Assert.assertTrue(uploadPage.isFileLoadSuccess(threeImg));
        uploadPage.clickStartButtonEachFile();
        Assert.assertTrue(uploadPage.isFileUpLoadSuccess(oneImg));
        Assert.assertTrue(uploadPage.isFileUpLoadSuccess(twoImg));
        Assert.assertTrue(uploadPage.isFileUpLoadSuccess(threeImg));
    }
    @Test
    public void User_03_Upload_GoFile() {
        uploadPage.openUrl(driver, "https://gofile.io/?t=uploadFiles");
        Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());
        uploadPage.clickToUploadFilesButton();
        uploadPage.sleepInSeconds(2);
        uploadPage.uploadMultipleFiles(driver, fileNames);
        Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());
        Assert.assertTrue(uploadPage.isMultipleProgressBarIconDisappear());
        Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));
        uploadPage.clickToSuccessLink();
        Assert.assertTrue(uploadPage.isContentTableDisplay());
        Assert.assertTrue(uploadPage.isDownLoadButtonDisplay(oneImg));
        Assert.assertTrue(uploadPage.isDownLoadButtonDisplay(twoImg));
        Assert.assertTrue(uploadPage.isDownLoadButtonDisplay(threeImg));

        Assert.assertTrue(uploadPage.isPlayButtonDisplay(oneImg));
        Assert.assertTrue(uploadPage.isPlayButtonDisplay(twoImg));
        Assert.assertTrue(uploadPage.isPlayButtonDisplay(threeImg));
    }


    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }

}
