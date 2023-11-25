package com.defacto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class BasketCard extends BasePage{
    public BasketCard(WebDriver driver) {
        super(driver);
    }

    public static Logger log  = Logger.getLogger(BasketCard.class);
    //private final By basketSummaryButtonLocator = By.xpath("/html/body/header/div[2]/div[3]/div[4]/a/span[1]");
    private final By basketProductCount = By.xpath("//a[@id='flycartBtn']//span[@class='mini-basket-count']");
    private final By goToCartPageButtonLocator = By.xpath("//a[@id='flycartBtn']");

    public boolean isProductOnBasket() throws InterruptedException {
        Thread.sleep(5000);
        if (Objects.equals(findElement(basketProductCount).getText(), "1")) {
            log.info("verify_number_of_product_on_basket [SUCCESS]");
            return true;
        } else {
            log.error("verify_number_of_product_on_basket [ERROR]");
            return false;
        }
    }

/*    public void clickBasketSummary() {
        clickElement(basketSummaryButtonLocator);
    }
*/
    public void goToCartpage() {
        clickElement(goToCartPageButtonLocator);
    }
}
