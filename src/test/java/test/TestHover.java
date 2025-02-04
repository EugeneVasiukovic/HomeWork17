package test;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class TestHover {

    SoftAssertions softAssertions = new SoftAssertions();


    @Test
    public void TestCheckHoverFirstImage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstImage = driver.findElements(By.cssSelector(".figure")).get(0);
        WebElement elementUser = firstImage.findElement(By.tagName("img"));

        Actions hoverActions = new Actions(driver);
        hoverActions.moveToElement(elementUser).perform();

        WebElement userName = firstImage.findElement(By.tagName("h5"));
        String userNameOne = userName.getText();
        softAssertions.assertThat(userNameOne).isNotNull().isNotEmpty();

        WebElement profileLink = firstImage.findElement(By.tagName("a"));
        profileLink.click();

        String pageSource = driver.getPageSource();
        softAssertions.assertThat(pageSource).doesNotContain("Not Found");

        driver.quit();
    }

    @Test
    public void TestCheckHoverSecondImage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement secondImage = driver.findElements(By.cssSelector(".figure")).get(1);
        WebElement elementUser = secondImage.findElement(By.tagName("img"));

        Actions hoverActions = new Actions(driver);
        hoverActions.moveToElement(elementUser).perform();

        WebElement userName = secondImage.findElement(By.tagName("h5"));
        String userNameOne = userName.getText();
        softAssertions.assertThat(userNameOne).isNotNull().isNotEmpty();

        WebElement profileLink = secondImage.findElement(By.tagName("a"));
        profileLink.click();

        String pageSource = driver.getPageSource();
        softAssertions.assertThat(pageSource).doesNotContain("Not Found");

        driver.quit();
    }

    @Test
    public void TestCheckHoverThirdImage(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement thirdImage = driver.findElements(By.cssSelector(".figure")).get(2);
        WebElement elementUser = thirdImage.findElement(By.tagName("img"));


        Actions hoverActions = new Actions(driver);
        hoverActions.moveToElement(elementUser).perform();

        WebElement userName = thirdImage.findElement(By.tagName("h5"));
        String userNameOne = userName.getText();
        softAssertions.assertThat(userNameOne).isNotNull().isNotEmpty();

        WebElement profileLink = thirdImage.findElement(By.tagName("a"));
        profileLink.click();

        String pageSource = driver.getPageSource();
        softAssertions.assertThat(pageSource).doesNotContain("Not Found");

        driver.quit();
    }
    @AfterClass
    public void ResultTest(){
        softAssertions.assertAll();
    }
}