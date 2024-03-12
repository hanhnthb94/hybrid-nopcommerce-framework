package pageUIs;

public class HomPageUI {
    // public: Truy cap tu cac class ben ngoai package theo cach thong thuong
    // private: Cac class ben ngoai k truy cap dc
    // default: Cac class ben ngoai khac package k truy cap dc
    // protected: Bat buoc phai ke thua moi truy cap dc
    // static: Co the truy cap truc tiep tu pham vi class - chu ko can pham vi tu instance
    // final: khong cho phep ghi đè len bien nay nua, ngan can viec gan lai thanh 1 element khac
    // String: Cac By locator deu nhan tham so vao la String
    // ten bien: static + final: mac dinh la hang so - Constant, tu dong in dam + in nghien
    // Hang so trong java: bat buoc phai viet hoa va phan cach bang _
    // Gia tri: Nam trong dau ""
    // Cu phap XPath
    // Khong can khoi tao 1 doi tuong dai dien cho class do de truy cap toi
    // Goi den 1 class khac package thi can phia import
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String LOGIN_LINK = "//a[@class='ico-login']";
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account' and text()='My account']";
}
