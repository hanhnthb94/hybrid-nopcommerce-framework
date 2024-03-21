package commons;

public class GlobalConstants {
    // Server Url: DEV/ Testing/ Staging/ Product
    // Database: DEV/ Testing/ Staging/ Product
    // Timeout: Short/ long
    // UserName/ Password
    // Third Party: Sandbox Paypal
    // retry fail
    // Download/ upload folder
    // Relative Project Path
    // OS Name
    // Cloud testing: Browserstack/ Saucolab/ CrossbrowserTesting (Access token/ ID)
    // ...

    public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final String PANDA_USER_URL = "http://live.techpanda.org/";
    public static final String PANDA_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
    public static final String DEV_ADMIN_PASSWORD = "admin";
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + "/uploadFiles";
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + "/downloadFiles";
}
