package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestAddRemoveButton {

    @Test
    public void checkAddButton() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        Actions doubleClickAction = new Actions(driver);
        doubleClickAction.doubleClick(buttonAdd).perform();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));

        Assert.assertEquals(deleteButtons.size(), 2);
        Assert.assertTrue(deleteButtons.get(0).isDisplayed());
        Assert.assertTrue(deleteButtons.get(1).isDisplayed());
        driver.quit();
    }
    @Test
    public void checkRemoveButton(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        Actions doubleClickAction = new Actions(driver);
        doubleClickAction.doubleClick(buttonAdd).perform();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.get(1).click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(), 1);
        driver.quit();
    }
}