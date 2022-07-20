package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebPage {
    private static WebDriver driver;
    static String urlDriverChrome  = System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe";

    public static WebDriver createChrome() {

        System.setProperty("webdriver.chrome.driver", urlDriverChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/login");
        return driver;
    }
}
