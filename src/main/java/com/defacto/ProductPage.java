package com.defacto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static Logger log  = Logger.getLogger(ProductPage.class);


    private final By nowBuyButtonLocator = By.xpath("//div[@class='product-payment-options__title']");
    private final By addProductToBasketButtonLocator = By.cssSelector(".action-btn-text1");
    private final By selectSizeLocator = By.xpath("//button[@value='S']");

    public boolean isOnProductPage() {
        if (isDisplayed(nowBuyButtonLocator)){
            log.info("verify_product_page [SUCCESS]");
            return true;
        }else{
            log.error("verify_product_page [ERROR]");
            return false;
        }
    }
    public void selectProductSize() {
        clickElement(selectSizeLocator);
    }
    public void addProductToBasket() {
        clickElement(addProductToBasketButtonLocator);
    }
}
