package javaBasic;

import commons.GlobalConstants;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

public class test {


    @BeforeSuite
    public void deleteFileInReport() {
        deleteAllFileInFolder("allure-json");
    }

    @Test
    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
            System.out.println(pathFolderDownload);
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            System.out.println(listOfFiles.length);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
