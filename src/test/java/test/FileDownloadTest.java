package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadTest {
    WebDriver driver;
    String downloadPath = "C:\\Users\\Yeuheni\\Desktop\\tech my skill\\HomeWork17\\src\\test\\resources";

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

    private boolean waitForFileToDownload(File file, int timeoutInSeconds) {
        int timeElapsed = 0;
        while (timeElapsed < timeoutInSeconds) {
            if (file.exists()) {
                return true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeElapsed++;
        }
        return false;
    }

    @Test
    public void checkFileDownloadTest(){
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement downloadLink = driver.findElement(By.linkText("some-file.txt"));
        downloadLink.click();
        File downloadedFile = new File(downloadPath + "/some-file.txt");
        boolean isDownloaded = waitForFileToDownload(downloadedFile, 10);

        Assert.assertTrue(isDownloaded);
    }

    @BeforeMethod
    public void quitDriver(){
        driver.quit();
    }
}