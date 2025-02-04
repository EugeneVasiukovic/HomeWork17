package test;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestTables {

    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void testCheckHeaderTables() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> headerTables = driver.findElements(By.xpath("//table[1]//th"));
        String[] cellName = {"Last Name", "First Name", "Email", "Due", "Web Site", "Action"};

        for (int i = 0; i < headerTables.size(); i++) {
            softAssertions.assertThat(headerTables.get(i).getText()).isEqualTo(cellName[i]);
        }
        driver.quit();
    }

    @Test
    public void testCheckCellTables() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> cellTables = driver.findElements(By.xpath("//table[1]//tr[1]//td"));
        String[] tableRows = {"Smith", "John", "jsmith@gmail.com" , "$50.00", "http://www.jsmith.com", "edit delete"};

        for (int i = 0; i < cellTables.size(); i++){
            softAssertions.assertThat(cellTables.get(i).getText()).isEqualTo(tableRows[i]);
        }
        driver.quit();
    }
    @AfterClass
    public void resultTest(){
        softAssertions.assertAll();
    }
}