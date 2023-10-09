package com.defacto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void clickElement(By locator){
        waitUntilItemShowsUp(locator);
        findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        waitUntilItemShowsUp(locator);
        return findElement(locator).isDisplayed();
    }

    public void waitUntilItemShowsUp(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void mouseover(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(locator)).perform();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
    }

    public void type(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public WebElement findElementWithText(String text){
        return driver.findElement(By.linkText(text));
    }

    public void clickText(String text){
        findElementWithText(text).click();
    }
}
