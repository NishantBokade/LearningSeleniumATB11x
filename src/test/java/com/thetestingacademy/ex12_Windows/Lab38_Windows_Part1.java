package com.thetestingacademy.ex12_Windows;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Set;

public class Lab38_Windows_Part1 extends CommonToAll {
    @Test
    public void test_windows() {

        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

        String parent = driver.getWindowHandle();
        System.out.println(parent);
        //304F639A7D222FA0C1C048527746D036

        WebElement link_parent = driver.findElement(By.xpath("//a[text()=\"Click Here\"]"));
        link_parent.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);


        for (String handle: windowHandles){
            driver.switchTo().window(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed!");
            }
            driver.switchTo().window(parent);
        }

    }
}