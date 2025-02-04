package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestDropdown {

    @Test
    public void TestGetAllElemetsDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select elementsDropdown = new Select(dropdown);
        List<WebElement> allElementsDropdown = elementsDropdown.getOptions();
        String[] DropdownOptions = {"Please select an option", "Option 1", "Option 2"};

        for (int i = 0; i < DropdownOptions.length; i++) {
            Assert.assertEquals(allElementsDropdown.get(i).getText(), DropdownOptions[i]);

        }
        driver.quit();
    }

    @Test
    public void TestGetFirstElemetsDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select elementsDropdown = new Select(dropdown);
        elementsDropdown.selectByIndex(1);
        WebElement getFirstElementDropdown = elementsDropdown.getFirstSelectedOption();
        Assert.assertEquals(getFirstElementDropdown.getText(), "Option 1");
        driver.quit();
    }

    @Test
    public void TestGetSecondElemetsDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select elementsDropdown = new Select(dropdown);
        elementsDropdown.selectByIndex(2);
        WebElement getSecondElementDropdown = elementsDropdown.getFirstSelectedOption();
        Assert.assertEquals( getSecondElementDropdown.getText(), "Option 2");
        driver.quit();
    }
}