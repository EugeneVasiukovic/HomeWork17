package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNotification {

    @Test
    public void herokuAppTestCheckNotification(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");

        WebElement buttonClickHere = driver.findElement(By.linkText("Click here"));
        buttonClickHere.click();
        WebDriverWait waitNotification = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = waitNotification.until
                (ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String expectedResult = "Action successful";
        String actualResult = notification.getText().replace("×","").trim();

        Assert.assertEquals(actualResult,expectedResult);
        driver.quit();
    }
}