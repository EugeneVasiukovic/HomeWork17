package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestTypos {

    @Test
    public void checkedTestTypos(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/typos");
        List<WebElement> textParagraph = driver.findElements(By.tagName("p"));
        String actualText = textParagraph.get(0).getText() + "\n\n" + textParagraph.get(1).getText();

        String expectedText = "This example demonstrates a typo being introduced. It does it randomly on each page load.\n\n" +
                "Sometimes you'll see a typo, other times you won't.";

        Assert.assertEquals(actualText.toString(), expectedText);
        driver.quit();
    }
}