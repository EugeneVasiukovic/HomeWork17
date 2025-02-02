package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTestTables {

    @Test
    public void HerokuAppTestCheckHeaderTables() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement headerOne = driver.findElement(By.xpath("//table[1]//th[1]"));
        WebElement headerTwo = driver.findElement(By.xpath("//table[1]//th[2]"));
        WebElement headerThree = driver.findElement(By.xpath("//table[1]//th[3]"));
        WebElement headerFour = driver.findElement(By.xpath("//table[1]//th[4]"));
        WebElement headerFive = driver.findElement(By.xpath("//table[1]//th[5]"));
        WebElement headerSix = driver.findElement(By.xpath("//table[1]//th[6]"));

        Assert.assertEquals("Last Name", headerOne.getText());
        Assert.assertEquals("First Name", headerTwo.getText());
        Assert.assertEquals("Email", headerThree.getText());
        Assert.assertEquals("Due", headerFour.getText());
        Assert.assertEquals("Web Site", headerFive.getText());
        Assert.assertEquals("Action", headerSix.getText());

        driver.quit();
    }

    @Test
    public void HerokuAppTestCheckCellTables() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement cellOne = driver.findElement(By.xpath("//table[1]//tr[1]//td[1]"));
        WebElement cellTwo = driver.findElement(By.xpath("//table[1]//tr[1]//td[2]"));
        WebElement cellThree = driver.findElement(By.xpath("//table[1]//tr[1]//td[3]"));
        WebElement cellFour = driver.findElement(By.xpath("//table[1]//tr[1]//td[4]"));
        WebElement cellFive = driver.findElement(By.xpath("//table[1]//tr[1]//td[5]"));

        Assert.assertEquals("Smith", cellOne.getText());
        Assert.assertEquals("John", cellTwo.getText());
        Assert.assertEquals("jsmith@gmail.com", cellThree.getText());
        Assert.assertEquals("$50.00", cellFour.getText());
        Assert.assertEquals("http://www.jsmith.com", cellFive.getText());
        driver.quit();
    }
}