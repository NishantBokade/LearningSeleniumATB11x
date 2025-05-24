package com.thetestingacademy.ex15_Relative_locators;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

public class Lab43_RL_P3_REAL_EXAMPLE extends CommonToAll {

    @Test
    public void test_js() {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        WebElement SearchBox = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        SearchBox.sendKeys("india" + Keys.ENTER);

        waitForJVM(5000);

        List<WebElement> locations = driver.findElements(By.xpath("//div[contains(@class,\"location-name\")]/p"));

        for(WebElement location: locations){
            String rank =driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String aqi =driver.findElement(with(By.tagName("span")).toRightOf(location)).getText();

            System.out.println("| +" + rank + " | " + location.getText() + " | " + aqi + " | ");

        }
    }
}