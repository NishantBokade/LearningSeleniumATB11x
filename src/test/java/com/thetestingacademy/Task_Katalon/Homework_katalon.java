package com.thetestingacademy.Task_Katalon;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;

public class Homework_katalon {

    @Owner("Nishant")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify make_appointmen of katalon app")
    @Test
    public void test_katalon_login() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement make_appointment_btn_xpath = driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
        make_appointment_btn_xpath.click();


        List<WebElement> username_input_box_btn_xpath_placeholder = driver.findElements(By.xpath("//input[@placeholder=\"Username\"]"));
        username_input_box_btn_xpath_placeholder.get(1).sendKeys("John Doe");

        List<WebElement> password_input_box_btn_xpath_placeholder = driver.findElements(By.xpath("//input[@placeholder=\"Password\"]"));
        password_input_box_btn_xpath_placeholder.get(1).sendKeys("ThisIsNotAPassword");


        WebElement login_btn_xpath = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        login_btn_xpath.click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        //make_appointment process
        WebElement make_facility = driver.findElement(By.xpath("//select[@id=\"combo_facility\"]"));

        Select select = new Select(make_facility);
        select.selectByContainsVisibleText("Seoul CURA Healthcare Center");
        //check box
         WebElement checkbox = driver.findElement(By.xpath("//input[@id=\"chk_hospotal_readmission\"]"));
         checkbox.click();
        //Radio Button
        WebElement Healthcare_Program = driver.findElement(By.xpath("//input[@id=\"radio_program_medicaid\"]"));
        Healthcare_Program.click();
        //dates
        driver.findElement(By.xpath("//input[@id=\"txt_visit_date\"]")).sendKeys("22/05/2025");
        //comments
        driver.findElement(By.xpath("//textarea[@id=\"txt_comment\"]")).sendKeys("Book my appointment");

        WebElement book_apt_btn = driver.findElement(By.xpath("//button[@id=\"btn-book-appointment\"]"));
        book_apt_btn.click();

        //Assertion
        Assertion assertion = new Assertion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-12 text-center']/h2")));
        String get_string=driver.findElement(By.xpath("//div[@class='col-xs-12 text-center']/h2")).getText();
        assertion.assertEquals(get_string,"Appointment Confirmation");

        driver.quit();
    }
}