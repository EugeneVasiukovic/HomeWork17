package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HerokuAppTestAddRemove {

    @Test
    public void HerokuAppAddTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        Actions doubleClickButton = new Actions(driver);
        doubleClickButton.doubleClick(buttonAdd).perform();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text ()='Delete']"));

        Assert.assertEquals(2,deleteButtons.size());
        Assert.assertTrue(deleteButtons.get(0).isDisplayed());
        Assert.assertTrue(deleteButtons.get(1).isDisplayed());
        driver.quit();
    }
    @Test
    public void HerokuAppRemoveTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        Actions doubleClickButton = new Actions(driver);
        doubleClickButton.doubleClick(buttonAdd).perform();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text ()='Delete']"));
        deleteButtons.get(1).click();
        deleteButtons = driver.findElements(By.xpath("//button[text ()='Delete']"));
        Assert.assertEquals(1,deleteButtons.size());
        driver.quit();
    }
}