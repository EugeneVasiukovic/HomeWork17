package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCheckbox {

    @Test
    public void testFirstCheckboxUnchecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(firstCheckbox.isSelected());
        driver.quit();
    }

    @Test
    public void testFirstCheckboxChecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected());
        driver.quit();
    }

    @Test
    public void testSecondCheckboxChecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> secondCheckbox = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertTrue(secondCheckbox.get(1).isSelected());
        driver.quit();
    }

    @Test
    public void testSecondCheckboxUnChecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> secondCheckbox = driver.findElements(By.cssSelector("[type=checkbox]"));
        secondCheckbox.get(1).click();
        Assert.assertFalse(secondCheckbox.get(1).isSelected());
        driver.quit();
    }
}