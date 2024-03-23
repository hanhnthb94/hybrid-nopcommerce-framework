package javaBasic;

import org.openqa.selenium.support.FindBy;

import java.io.File;

public class Topic_06_Upload {
    static String[] fileNames = {"one.jpg", "two.jpg", "three.jpg"};
    static String fullFileName = "";

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;
        System.out.println(filePath);
        for (String file : fileNames) {
            System.out.println(file);
            fullFileName = fullFileName + filePath + file + "\n";
            System.out.println(fullFileName);
        }
        fullFileName = fullFileName.trim();
        System.out.println(fullFileName);

    }

}
