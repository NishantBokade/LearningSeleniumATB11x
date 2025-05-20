package com.thetestingacademy.ex04_selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21_MiniProject_3 {


    @Owner("Nishant")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that with valid email, pass, appointment page is loaded")
    @Test
    public void test_katalon_login() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement make_appointment_btn_xpath = driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
        make_appointment_btn_xpath.click();


        List<WebElement> username_input_box_btn_xpath_placeholder =driver.findElements(By.xpath("//input[@placeholder=\"Username\"]"));
        username_input_box_btn_xpath_placeholder.get(1).sendKeys("John Doe");

        List<WebElement> password_input_box_btn_xpath_placeholder = driver.findElements(By.xpath("//input[@placeholder=\"Password\"]"));
        password_input_box_btn_xpath_placeholder.get(1).sendKeys("ThisIsNotAPassword");


        WebElement login_btn_xpath = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        login_btn_xpath.click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");


        driver.quit();

    }

    }
