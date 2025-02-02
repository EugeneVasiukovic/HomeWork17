package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HerokuAppTestCheckbox {

    @Test
    public void herokuAppTestFirstCheckboxUnchecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckboxUnchecked = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(firstCheckboxUnchecked.isSelected());
        driver.quit();
    }

    @Test
    public void herokuAppTestFirstCheckboxChecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckboxChecked = driver.findElement(By.cssSelector("[type=checkbox]"));
        firstCheckboxChecked.click();
        Assert.assertTrue(firstCheckboxChecked.isSelected());
        driver.quit();
    }

    @Test
    public void herokuAppTestSecondCheckboxChecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> secondCCheckboxChecked = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertTrue(secondCCheckboxChecked.get(1).isSelected());
        driver.quit();
    }

    @Test
    public void herokuAppTestSecondCheckboxUnChecked() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> secondCheckboxChecked = driver.findElements(By.cssSelector("[type=checkbox]"));
        secondCheckboxChecked.get(1).click();
        Assert.assertFalse(secondCheckboxChecked.get(1).isSelected());
        driver.quit();
    }
}