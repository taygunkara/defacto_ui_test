package com.defacto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static Logger log  = Logger.getLogger(HomePage.class);

    private final By homePageBannerLocator = By.cssSelector("#cm-ee542db1-a62a-4e3c-b95f-532709797c38 > div");
    private final By womanCategoryLocator = By.xpath("/html/body/main/section/section/div/div/a[1]");

    public boolean isOnHomePage(){
        if (isDisplayed(homePageBannerLocator)){
            log.info("verify_homepage [SUCCESS]");
            return true;
        }else{
            log.error("verify_homepage [ERROR]");
            return false;
        }
    }
    public void clickWomanCategory() {
        clickElement(womanCategoryLocator);
    }

}
