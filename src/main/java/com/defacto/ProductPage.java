package com.defacto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static Logger log  = Logger.getLogger(ProductPage.class);

    private final By nowBuyButtonLocator = By.cssSelector("#cm-d3ac8224-56ad-4f3b-8537-b949660d8fdb > div > div > div.product-payment-options__title");
    private final By addProductToBasketButtonLocator = By.cssSelector(".action-btn-text1");
    private final By selectSizeLocator = By.cssSelector("button.cross-border-button:nth-child(2)");

    public boolean isOnProductPage() {
        if (isDisplayed(nowBuyButtonLocator)){
            log.info("verify_product_page [SUCCESS]");
            return true;
        }else{
            log.error("verify_product_page [ERROR]");
            return false;
        }
    }
    public void selectRandomSize() {
        clickElement(selectSizeLocator);
    }
    public void addProductToBasket() {
        clickElement(addProductToBasketButtonLocator);
    }
}
