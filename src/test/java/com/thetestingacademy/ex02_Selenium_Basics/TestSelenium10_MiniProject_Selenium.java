package com.thetestingacademy.ex02_Selenium_Basics;
import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium10_MiniProject_Selenium extends CommonToAll {


    @Description("Open the URL")
    @Test
    public void test_Selenium01() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();

        if (driver.getPageSource().contains("CURA Healthcare Service")) {
            System.out.println("Testcase Passed!");

        } else {
            Assert.fail("CURA Healthcare Service is not visible");
           // throw new Exception("CURA Healthcare Service is not visible");
        }
        closeBrowser(driver);
    }
}