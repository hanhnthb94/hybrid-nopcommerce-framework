package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.UploadPageUI;

import java.util.List;

public class UploadPageObject extends BasePage {
    private WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoadSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
    }

    public void clickStartButtonEachFile() {
        List<WebElement> startButton = getListElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
        for (WebElement button : startButton) {
            waitForElementClickable(driver, button);
            clickToElement(driver, button);
            sleepInSeconds(2);
        }
    }

    public boolean isFileUpLoadSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
    }

    public boolean isLoadingIconAtMainContentDisappear() {
        return waitForElementInvisibleBoolean(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
    }

    public boolean isLoadingIconAtMainUploadDisappear() {
        return waitForElementInvisibleBoolean(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
    }

    public boolean isMultipleProgressBarIconDisappear() {
        return waitForListElementInVisibleBoolean(driver, UploadPageUI.MULTIPLE_PROGRESS_BAR_ICON);
    }

    public boolean isSuccessMessageDisplayed(String successMessage) {
        waitForElementVisible(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
        return isElementDisplayed(driver, UploadPageUI.UPLOADED_SUCCESS_MESSAGE, successMessage);
    }

    public void clickToSuccessLink() {
        waitForElementClickable(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
        clickToElement(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
    }

    public boolean isContentTableDisplay() {
        waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
        return isElementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
    }

    public boolean isDownLoadButtonDisplay(String fileName) {
        waitForElementVisible(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
    }

    public boolean isPlayButtonDisplay(String fileName) {
        waitForElementVisible(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
    }

    public void clickToUploadFilesButton() {
        waitForElementClickable(driver, UploadPageUI.UPLOAD_FILES_BUTTON);
        clickToElement(driver, UploadPageUI.UPLOAD_FILES_BUTTON);
    }
}
