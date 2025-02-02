package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HerokuAppTestDropdown {

    @Test
    public void herokuAppTestGetAllElemetsDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement elemetsDropdownGet = driver.findElement(By.id("dropdown"));
        Select elementsDropdown = new Select(elemetsDropdownGet);
        List<WebElement> allElementsDropdown = elementsDropdown.getOptions();
        String[] mockExpectedOptions = {"Please select an option", "Option 1", "Option 2"};

        for (int i = 0; i < mockExpectedOptions.length; i++) {
            Assert.assertEquals(mockExpectedOptions[i], allElementsDropdown.get(i).getText());

        }
        driver.quit();
    }

    @Test
    public void herokuAppTestGetFirstElemetsDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement elemetsDropdownGet = driver.findElement(By.id("dropdown"));
        Select elementsDropdown = new Select(elemetsDropdownGet);
        elementsDropdown.selectByIndex(1);
        WebElement getFirstElementDropdown = elementsDropdown.getFirstSelectedOption();
        Assert.assertEquals("Option 1", getFirstElementDropdown.getText());
        driver.quit();
    }

    @Test
    public void herokuAppTestGetSecondElemetsDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement elemetsDropdownGet = driver.findElement(By.id("dropdown"));
        Select elementsDropdown = new Select(elemetsDropdownGet);
        elementsDropdown.selectByIndex(2);
        WebElement getSecondElementDropdown = elementsDropdown.getFirstSelectedOption();
        Assert.assertEquals("Option 2", getSecondElementDropdown.getText());
        driver.quit();
    }
}