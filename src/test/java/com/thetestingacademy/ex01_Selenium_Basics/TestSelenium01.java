package com.thetestingacademy.ex01_Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {

    @Test
    public void test_openVWOLoginPage() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://sdet.live");
        driver.quit();
    }
}
