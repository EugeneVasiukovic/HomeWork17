package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest {
    WebDriver driver;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @Test(description = "The test verifies that an alert opens, parses the text from the alert, compares it with the expected text, and checks that the alert modal closes.")
    public void checkMouseRightClickTest(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement contextElement = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.moveToElement(contextElement).contextClick().perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        boolean isAlertClosed = !isAlertPresent();

        Assert.assertEquals(alertText, "You selected a context menu");
        Assert.assertTrue(isAlertClosed);
    }

    @AfterMethod
    public void quitTest(){
        driver.quit();
    }
}
