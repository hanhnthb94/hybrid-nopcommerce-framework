package pageUIs.techpanda;

public class AdminDashboardPageUIPD {
    public static final String CLOSE_POPUP_BUTTON = "xpath=//div[@id='message-popup-window']//span[text()='close']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@name='email']";
    public static final String COLUMN_TEXTBOX_BY_EMAIL = "xpath=//a[@name='email']//ancestor::tr/following-sibling::tr//input[@name='email']";
    public static final String DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[@class='even pointer'][%s]/td[%s]";
}
