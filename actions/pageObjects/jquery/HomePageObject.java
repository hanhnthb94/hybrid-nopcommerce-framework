package pageObjects.jquery;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.RegisterPageObject;
import pageUIs.jquery.HomPageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToColumnTextboxByName(String columnName, String valueToSend) {
        waitForElementVisible(driver, HomPageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
        sendkeyToElement(driver, HomPageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
    }

    public void clickToPageByNumber(String pageNumber) {
        waitForElementVisible(driver, HomPageUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomPageUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }
    public boolean isPageActiveByNumber(String pageNumber) {
        waitForElementVisible(driver, HomPageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomPageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }
    public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomPageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
        return isElementDisplayed(driver, HomPageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
    }
    public void clickToRowActionByCountryName(String country, String rowAction) {
        waitForElementClickable(driver, HomPageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
        clickToElement(driver, HomPageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
    }

    // Get ra tu UI
    public List<String> getAllPageValuesByColumnName(String columnName) {
        List<String> allValues = new ArrayList<String>();
        // Bước 1: Lấy ra tất cả các page // Bước 2: Duyệt qua từng page
        List<WebElement> allPageLinks = getListElement(driver, HomPageUI.ALL_PAGE_LINK);
        int columnIndex = getListElementSize(driver, HomPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        for (WebElement pageLink : allPageLinks) {
            pageLink.click();
            // Bước 3: Lấy ra tất cả các giá trị của 1 cột trong cái page đó -> Lưu nó vào List/ Set/...
            List<WebElement> allRowValues = getListElement(driver, HomPageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));

            for (WebElement rowValue : allRowValues) {
                allValues.add(rowValue.getText());
            }
        }
        for (String value : allValues) {
            System.out.println(value);
        }
        // sort ASC/ DESC
        return allValues;
        // In ra all value cua 1 cot trong all page
    }


    public void enterToTextboxByColumnNameAndRowIndex(String columnName,String rowIndex,  String valueToSend) {
        int columnIndex = getListElementSize(driver, HomPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementVisible(driver, HomPageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        sendkeyToElement(driver, HomPageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));



    }

    public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
        int columnIndex = getListElementSize(driver, HomPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementClickable(driver, HomPageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        selectDropdown(driver, HomPageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, rowIndex, String.valueOf(columnIndex));
    }

    public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
        int columnIndex = getListElementSize(driver, HomPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForElementClickable(driver, HomPageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        checkToElement(driver, HomPageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
    }
}

