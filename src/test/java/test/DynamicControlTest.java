package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DynamicControlTest {
    WebDriver driver;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public boolean isElementNotPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Test
    public void checkDynamicControlTest(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        boolean checkboxIsNotPresent = isElementNotPresent(driver, By.id("checkbox"));
        WebElement inputElement = driver.findElement(By.xpath("//input"));
        boolean inputIsDisabled = !inputElement.isEnabled();
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button ")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's enabled!\"]")));
        boolean inputIsEnabled = inputElement.isEnabled();

        softAssert.assertTrue(checkboxIsNotPresent);
        softAssert.assertTrue(inputIsDisabled);
        softAssert.assertTrue(inputIsEnabled);
        softAssert.assertAll();
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
