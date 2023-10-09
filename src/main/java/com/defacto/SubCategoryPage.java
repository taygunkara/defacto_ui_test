package com.defacto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage extends BasePage{
    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    private final By moreSizeButtonLocator = By.xpath("/html/body/main/div/div[6]/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/button[1]");
    private final By smallSizeCheckboxLocator = By.xpath("//*[@id=\"catalog-filter__nav\"]/ul/li[2]/ul/li[2]/ul/li[18]/div/label");
    private final By searchSizeBoxLocator = By.xpath("/html/body/main/div/div[6]/div/div[1]/div/div/div/ul/li[2]/ul/li[1]/div/input");
    private final By productLocator = By.xpath("//*[@id=\"product-fill\"]/div/div[3]/div/div[1]/div[3]/a");

    public void selectSmallSize() {
        scrollDown();
        clickElement(moreSizeButtonLocator);
        type(searchSizeBoxLocator, "s");
        clickElement(smallSizeCheckboxLocator);
    }
    public void selectProduct() throws InterruptedException {

        try {
            Thread.sleep(2000);
            clickElement(productLocator);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            Thread.sleep(2000);
            clickElement(productLocator);
        }
    }
}
