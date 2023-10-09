package com.defacto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;
    public String BASE_URL = "https://www.defacto.com.tr/";

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito").
                addArguments("--start-maximized").
                addArguments("--ignore-certificate-errors").
                addArguments("--allow-insecure-localhost").
                addArguments("--acceptInsecureCerts").
                addArguments("--disable-blink-features=AutomationControlled").
                addArguments("--disable-extensions");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    public void navigateToHome(){
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
