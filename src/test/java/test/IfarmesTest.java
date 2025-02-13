package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IfarmesTest {
    WebDriver driver;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkIframeTest(){
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.id("tinymce"));
        String iframeText = text.getText();
        driver.switchTo().defaultContent();
        Assert.assertEquals(iframeText, "Your content goes here.");
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
