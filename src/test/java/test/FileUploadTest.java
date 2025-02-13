package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkFileUploadTest(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement uploadFile = driver.findElement(By.id("file-upload"));
        String absolutePath = Paths.get("src/test/resources/Cat.jpg").toAbsolutePath().toString();
        uploadFile.sendKeys(absolutePath);
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        WebElement nameUploadFile = driver.findElement(By.id("uploaded-files"));

        Assert.assertEquals(nameUploadFile.getText(), "Cat.jpg");
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
