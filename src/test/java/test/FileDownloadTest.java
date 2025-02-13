package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadTest {
    WebDriver driver;
    String downloadPath = System.getProperty("user.dir") + "/src/test/resources";

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void checkFileDownloadTest(){
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement downloadLink = driver.findElement(By.linkText("test.jpg"));
        downloadLink.click();

        File folder = new File(downloadPath);
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File: " + listOfFile.getName());
                if (fileName.matches("test.jpg")) {
                    f = new File(folder, fileName);
                    found = true;
                }
            }
        }

        Assert.assertTrue(found);
        if (f != null) {
            f.deleteOnExit();
        }
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}