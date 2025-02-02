package test;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import org.testng.annotations.Test;

import java.util.List;

public class HerokuAppTestHover {

    @Test
    public void HerokuAppTestCheckHover() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> getImages = driver.findElements(By.cssSelector(".figure"));

        Actions hoverActions = new Actions(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        for (WebElement images : getImages) {
            WebElement image = images.findElement(By.tagName("img"));
            hoverActions.moveToElement(image).perform();

            WebElement userNameAll = images.findElement(By.tagName("h5"));
            String userNameOne = userNameAll.getText();
            softAssertions.assertThat(userNameOne).isNotNull().isNotEmpty();

            WebElement profileLink = images.findElement(By.tagName("a"));
            profileLink.click();

            String pageSource = driver.getPageSource();
            softAssertions.assertThat(pageSource).doesNotContain("Not Found");

            driver.navigate().back();
        }
        driver.quit();
        softAssertions.assertAll();
    }
}