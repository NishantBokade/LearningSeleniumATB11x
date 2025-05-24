package com.thetestingacademy.Task_Katalon;
import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.ArrayList;
import java.util.List;

public class EBayTask extends CommonToAll {

    @Test
    public void test_js() {
        driver.get("https://www.ebay.com/b/PC-Desktops-All-In-One-Computers/179/bn_661752");
        driver.manage().window().maximize();

        //Search for macmini and click search button
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
        searchBox.sendKeys("macmini" + Keys.ENTER);

        waitForJVM(5000);

        List<WebElement> Price_element = driver.findElements(By.xpath("//span[@class=\"s-item__price\"]"));

        List<Double> pricelist = new ArrayList<>();

        for (WebElement price : Price_element) {

            String pricetext = price.getText();

            if (pricetext.contains("to")){
            }
        }
        }
    }