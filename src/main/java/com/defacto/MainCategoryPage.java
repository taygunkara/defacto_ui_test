package com.defacto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainCategoryPage extends BasePage{
    public MainCategoryPage(WebDriver driver) {
        super(driver);
    }
    public static Logger log  = Logger.getLogger(MainCategoryPage.class);

    private final By clothesButtonLocator = By.xpath("/html/body/header/nav/ul[1]/li[1]");
    private final By jacketButtonLocator = By.xpath("/html/body/header/nav/ul[1]/li[1]/div/div[2]/ul[2]/li[4]/a");

    public boolean isAppearSubcategories() {
        if (isDisplayed(jacketButtonLocator)){
            log.info("verify_subcategories_appear [SUCCESS]");
            return true;
        }else{
            log.error("verify_subcategories_appear [ERROR]");
            return false;
        }
    }
    public void mouseoverClothesMenu() {
        mouseover(clothesButtonLocator);
    }
    public void clickSubCategory() {
        clickElement(jacketButtonLocator);
    }
}
