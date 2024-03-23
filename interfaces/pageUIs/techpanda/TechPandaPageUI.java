package pageUIs.techpanda;

public class TechPandaPageUI {
    public static final String MY_ACCOUNT_LINK = "xpath=//header//span[text()='Account']";
    public static final String REGISTER_LINK = "xpath=//a[text()='Register']";
    public static final String REGISTER_BUTTON = "xpath=//button[@title='Register']";
    public static final String REGISTER_MESSAGE = "css=.success-msg span";
    public static final String DYNAMIC_REGISTER_TEXTBOX = "xpath=//input[@id='%s']";

    public static final String LOGIN_BUTTON = "xpath=//input[@type='submit']";
    public static final String USER_NAME_TEXTBOX = "xpath=//input[@type='text']";
    public static final String PASSWORD_TEXTBOX = "xpath=//input[@type='password']";
    public static final String SEARCH_BUTTON = "xpath=//span[text()='Search']";



    public static final String CLOSE_POPUP_BUTTON = "xpath=//div[@id='message-popup-window']//span[text()='close']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@name='email']";
    public static final String COLUMN_TEXTBOX_BY_EMAIL = "xpath=//a[@name='email']//ancestor::tr/following-sibling::tr//input[@name='email']";
    public static final String DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[@class='even pointer'][%s]/td[%s]";

}
