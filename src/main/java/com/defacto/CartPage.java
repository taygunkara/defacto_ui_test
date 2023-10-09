package com.defacto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static Logger log  = Logger.getLogger(CartPage.class);

    private final By completeShoppingButtonLocator = By.xpath("//*[@id=\"summaryCompletedButton\"]");
    private final String deleteProductButtonText = "Sil";
    private final By secondDeleteButtonLocator = By.xpath("//*[@id=\"productDeleteModal\"]/div/div[2]/div[2]/button[2]");
    private final By checkCartPageLocator = By.cssSelector(".shopping__empty--title");

    public boolean isOnCartPage() {
        if (isDisplayed(completeShoppingButtonLocator)){
            log.info("verify_to_cartpage [SUCCESS]");
            return true;
        }else{
            log.error("verify_to_cartpage [ERROR]");
            return false;
        }
    }

    public void deleteProduct() {
        clickText(deleteProductButtonText);
        clickElement(secondDeleteButtonLocator);
    }
    public boolean isCartEmpty() {
        waitUntilItemShowsUp(checkCartPageLocator);
        if (Objects.equals(findElement(checkCartPageLocator).getText(), "Sepetinizde ürün yok.")){
            log.info("verify_empty_cartpage [SUCCESS]");
            return true;
        }else{
            log.error("verify_empty_cartpage [ERROR]");
            return false;
        }
    }
}
